package JavaForTesters.Lesson8.Homework08;

import JavaForTesters.Lesson8.Homework08.entity.WeatherData;
import JavaForTesters.Lesson8.Homework08.enums.Periods;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String NUMBER_DAYS = "5day";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();
    private static final String LANG = "ru-ru";
    private static final String METRIC = "true";

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException, SQLException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", LANG)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
//            String jsonResponseTest = new String("{\n" +                // for testing
//                    "\"LocalObservationDateTime\":\"2021-06-07T10:55:00+03:00\",\n" +
//                    "\"EpochTime\":1623052500, \n" +
//                    "\"WeatherText\":\"Mostly sunny\",\n" +
//                    "\"WeatherIcon\":2,\n" +
//                    "\"HasPrecipitation\":false,\n" +
//                    "\"PrecipitationType\":null,\n" +
//                    "\"IsDayTime\":true, \n" +
//                    "\"Temperature\":{\n" +
//                    "\"Metric\":{\n" +
//                    "\"Value\":22.2,\n" +
//                    "\"Unit\":\"C\",\n" +
//                    "\"UnitType\":17\n" +
//                    "},\n" +
//                    "\"Imperial\":{\n" +
//                    "\"Value\":72,\n" +
//                    "\"Unit\":\"F\",\n" +
//                    "\"UnitType\":18\n" +
//                    "}\n" +
//                    "},\n" +
//                    "\"MobileLink\":\"http://m.accuweather.com/en/ru/saint-petersburg/295212/current-weather/295212?lang=en-us\",\n" +
//                    "\"Link\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/current-weather/295212?lang=en-us\"\n" +
//                    "}");


            WeatherResponse[] weatherResponse = responseToClass(response.body().string());
            // вызвать метод сохранения погоды в базу из DataBaseRepository достав из weatherResponse данные для WeatherData
            // с помощью ObjectMapper.readTree или создать объект, повторяющий модель json (он есть - weatherResponse) и нужные данные поместить в WeatherDats

            // from json to WeatherData
            WeatherData weatherData = new WeatherData(ApplicationGlobalState.getInstance().getSelectedCity(), weatherResponse[0].getLocalObservationDateTime(),
                    weatherResponse[0].getWeatherText(), (double)weatherResponse[0].getTemperature().getMetric().getValue());
            DataBaseRepository dataBaseRepository = new DataBaseRepository();
            dataBaseRepository.saveWeatherData(weatherData);


            System.out.println("В городе " + ApplicationGlobalState.getInstance().getSelectedCity() + //
                    " сейчас " + weatherResponse[0].getTemperature().getMetric().getValue() + " " + weatherResponse[0].getTemperature().getMetric().getUnit() +
                    ", " + weatherResponse[0].getWeatherText());
        }

        if (periods.equals(Periods.FIVE_DAYS)) {   //5 Days of Daily Forecasts
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(DAILY)
                    .addPathSegment(NUMBER_DAYS)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", LANG)
                    .addQueryParameter("metric", METRIC)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();

            //System.out.println(response.body().string());
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println("В городе " + ApplicationGlobalState.getInstance().getSelectedCity());

            final JsonNode arrNode = objectMapper.readTree(response.body().string()).get("DailyForecasts");

            if (arrNode.isArray()) {
                for (final JsonNode objNode : arrNode) {
                    //JsonNode date = objNode.get("Date");
                    String date = objNode.get("Date").asText().substring(0,10);
                    System.out.print(date + " ");
                    String weatherConditions = objNode.at("/Day/IconPhrase").asText();
                    System.out.print(weatherConditions + "," + " температура днём ");
                    Integer dayTemperature = (int)Math.round(objNode.at("/Temperature/Maximum/Value").asDouble());
                    System.out.print(dayTemperature + " " + "\u00b0" + "C, температура ночью ");
                    Integer nightTemperature = (int)Math.round(objNode.at("/Temperature/Minimum/Value").asDouble());
                    System.out.println(nightTemperature + " " + "\u00b0" + "C");
                }
            }
        }

        if (periods.equals(Periods.SAVED)) {
            DataBaseRepository dataBaseRepository = new DataBaseRepository();
            List<WeatherData> listWeatherData = dataBaseRepository.getSavedWeatherData(ApplicationGlobalState.getInstance().getSelectedCity());
            System.out.println(listWeatherData);
        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }


    public WeatherResponse[] responseToClass(String responseString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse[] weatherNow = objectMapper.readValue(responseString, WeatherResponse[].class);
        return weatherNow;

    }
}
