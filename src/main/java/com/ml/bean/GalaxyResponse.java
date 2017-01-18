package com.ml.bean;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonProperty;
import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * Created by JesusLeon on 18/01/2017.
 */
@JsonPropertyOrder({ "droughtWeather", "rainingWeather", "maxRainingDay", "optimalWeather" })
public class GalaxyResponse {
    @JsonProperty("diasClimaSeco")
    private long droughtWeather = 0;
    @JsonProperty("diasClimaLluvioso")
    private long rainingWeather = 0;
    @JsonProperty("diasCondicionesOptimas")
    private long optimalWeather = 0;
    @JsonProperty("diaConMaximoPicoDeLluvia")
    private long maxRainingDay = 0;

    public long getDroughtWeather() {
        return droughtWeather;
    }

    public void setDroughtWeather(long droughtWeather) {
        this.droughtWeather = droughtWeather;
    }

    public long getRainingWeather() {
        return rainingWeather;
    }

    public void setRainingWeather(long rainingWeather) {
        this.rainingWeather = rainingWeather;
    }

    public long getOptimalWeather() {
        return optimalWeather;
    }

    public void setOptimalWeather(long optimalWeather) {
        this.optimalWeather = optimalWeather;
    }

    public long getMaxRainingDay() {
        return maxRainingDay;
    }

    public void setMaxRainingDay(long maxRainingDay) {
        this.maxRainingDay = maxRainingDay;
    }

}
