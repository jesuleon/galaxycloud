package com.ml.core;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;

/**
 * Created by JesusLeon on 17/01/2017.
 */
public class BuildGalaxy {
    private int countDroughtWeather = 0;
    private int countOptimalConditions = 0;
    private int countRainingWeather = 0;
    private int maxRainingDay = 0;
    private double maxPerimeter = 0;

    private Weather weather = Weather.DRAUGHT;

    public int getCountDroughtWeather() {
        return countDroughtWeather;
    }

    public int getCountOptimalConditions() {
        return countOptimalConditions;
    }

    public int getCountRainingWeather() {
        return countRainingWeather;
    }

    public Weather getWeather() {
        return weather;
    }

    public enum Weather {
        RAINING("Lluvioso"), NORMAL("Normal"), OPTIMAL("Óptimo"), DRAUGHT("Seco");

        private String description;

        Weather(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private void addWeatherDS(String clima, int day, Datastore datastore) {
        String kind = "Weather";
        Key key = datastore.newKeyFactory().setKind(kind).newKey(day);
        Entity galaxyEntity = Entity.newBuilder(key)
                .set("clima", clima)
                .build();

        datastore.put(galaxyEntity);
    }

    /**
     * Adds a galaxy into a datastore
     */
    private void addGalaxyDS(int numberOfDays, Datastore datastore) {
        String kind = "Galaxy";
        Key key = datastore.newKeyFactory().setKind(kind).newKey(numberOfDays);
        Entity galaxyEntity = Entity.newBuilder(key)
                .set("num-dias-clima-seco", countDroughtWeather)
                .set("num-dias-clima-lluvioso", countRainingWeather)
                .set("num-dias-optimas-condiciones", countOptimalConditions)
                .set("dia-que-mas-llovio", maxRainingDay)
                .build();

        datastore.put(galaxyEntity);
    }

    public void build(final int numberOfDays, Datastore datastore) {
        Galaxy galaxy = new Galaxy();

        for (int count = 1; count <= numberOfDays; count++) {
            if (galaxy.isDroughtWeather()) {
                countDroughtWeather++;
            } else if (galaxy.isOptimalConditions()) {
                countOptimalConditions++;
            } else if (galaxy.isRainingWeather()) {
                countRainingWeather++;

                double perimeterAux = galaxy.perimeter();

                if (perimeterAux > maxPerimeter) {
                    maxPerimeter = perimeterAux;
                    maxRainingDay = count;
                }
            }

            galaxy.simulateDay(count);
        }

        addGalaxyDS(numberOfDays, datastore);
    }

    public String weatherDay(final int day, Datastore datastore) {
        Galaxy galaxy = new Galaxy();
        String weatherDescription;

        galaxy.simulateDay(day-1);

        if (galaxy.isDroughtWeather()) {
            weatherDescription = Weather.DRAUGHT.getDescription();
        } else if (galaxy.isOptimalConditions()) {
            weatherDescription = Weather.OPTIMAL.getDescription();
        } else if (galaxy.isRainingWeather()) {
            weatherDescription = Weather.RAINING.getDescription();
        } else {
            weatherDescription = Weather.NORMAL.getDescription();
        }

        addWeatherDS(weatherDescription, day, datastore);

        return weatherDescription;
    }

}
