package JavaForTesters.Lesson8.Homework08;

import JavaForTesters.Lesson8.Homework08.enums.Functionality;
import JavaForTesters.Lesson8.Homework08.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_SAVED_WEATHER);
    }

    public void onUserInput(String input) throws IOException, SQLException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case GET_SAVED_WEATHER:
                getSavedWeather();
                break;
         }
    }

    public void getCurrentWeather() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.NOW);
    }

       public void getWeatherIn5Days() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.FIVE_DAYS);
    }

    public void getSavedWeather() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.SAVED);
    }


}
