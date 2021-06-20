package JavaForTesters.Lesson8.Homework08;

import JavaForTesters.Lesson8.Homework08.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException, SQLException;

}
