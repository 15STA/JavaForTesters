package JavaForTesters.Lesson8.Homework08;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {  // response about current weather

    @JsonProperty(value = "LocalObservationDateTime")
    private String localObservationDateTime;

    @JsonProperty(value = "EpochTime")
    private float epochTime;

    @JsonProperty(value = "WeatherText")
    private String weatherText;

    @JsonProperty(value = "WeatherIcon")
    private float weatherIcon;

    @JsonProperty(value = "HasPrecipitation")
    private boolean hasPrecipitation;

//    @JsonProperty(value = "PrecipitationType")
//    private String precipitationType; // = null;

    @JsonProperty(value = "IsDayTime")
    private boolean isDayTime;

    @JsonProperty(value = "Temperature")
    private Temperature temperature;

    @JsonProperty(value = "MobileLink")
    private String mobileLink;

    @JsonProperty(value = "Link")
    private String link;

    public WeatherResponse() {
    }

    // Getters methods

    public String getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    public float getEpochTime() {
        return epochTime;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public float getWeatherIcon() {
        return weatherIcon;
    }

    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

//    public String getPrecipitationType() {
//        return precipitationType;
//    }

    public boolean getIsDayTime() {
        return isDayTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public String getLink() {
        return link;
    }

    //Setters Methods

    public void setLocalObservationDateTime(String localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime;
    }

    public void setEpochTime(float epochTime) {
        this.epochTime = epochTime;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public void setWeatherIcon(float weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

//    public void setPrecipitationType(String precipitationType) {
//        this.precipitationType = precipitationType;
//    }

    public void setDayTime(boolean dayTime) {
        this.isDayTime = dayTime;
    }

    public void setTemperatureObject(Temperature temperature) {
        this.temperature = temperature;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public void setLink(String link) {
        this.link = link;
    }


}




