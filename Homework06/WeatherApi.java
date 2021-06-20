package JavaForTesters.Lesson6.Homework06;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherApi {
    final static String apiKey = "GCn4wR9UOdp8zFS4R529bdijzCikp1wI";

    OkHttpClient okHttpClient = new OkHttpClient();

    String run(HttpUrl url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        WeatherApi api5days = new WeatherApi();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("295212")
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("languages", "ru-ru")
                .addQueryParameter("details", "false")
                .addQueryParameter("metric", "true")
                .build();

        String response = api5days.run(url);
        System.out.println(response);

    }
}


