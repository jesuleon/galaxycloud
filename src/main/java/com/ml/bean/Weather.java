package com.ml.bean;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonProperty;
import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * Created by JesusLeon on 15/01/2017.
 */
@JsonPropertyOrder({ "day", "weather" })
public class Weather {
    @JsonProperty("dia")
    private int day;
    @JsonProperty("clima")
    private String weather;

    public int getDay() {
        return day;
    }

    public String getWeather() {
        return weather;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
