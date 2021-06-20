package JavaForTesters.Lesson8.Homework08;

import JavaForTesters.Lesson8.Homework08.entity.WeatherData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    public static final String DATA_BASE_NAME = "lesson8db.db";
    String insertLine = "insert into weather (city, localDate, weatherText, temperature) values (?, ?, ?, ?)";
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveWeatherData(WeatherData weatherData){
        try (Connection connection  = DriverManager.getConnection("jdbc:sqlite:lesson8db.db")) {
            PreparedStatement saveWeather = connection.prepareStatement(insertLine);
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getWeatherText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
      }

    public List<WeatherData> getSavedWeatherData(String cityName) {
        List<WeatherData> dataFromDataBase = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8db.db")) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM weather WHERE city = " + "'" + cityName +"'");
            int count = 0;
            while (resultSet.next()) {
                WeatherData weatherData = new WeatherData(resultSet.getString("city"), resultSet.getString("localDate"),
                        resultSet.getString("weatherText"), resultSet.getDouble("temperature"));
                dataFromDataBase.add(weatherData);
                count++;
            }
            if (count==0) {
                System.out.println("Для города " + cityName + " информация в базе отсутствует");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dataFromDataBase;
    }
}
