package JavaForTesters.Lesson7.Homework07;

import JavaForTesters.Lesson7.Homework07.enums.Periods;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

}
