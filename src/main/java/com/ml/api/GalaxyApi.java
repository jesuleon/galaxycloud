package com.ml.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.cloud.datastore.*;
import com.ml.Constants;
import com.ml.bean.GalaxyResponse;
import com.ml.bean.Weather;
import com.ml.core.BuildGalaxy;

/**
 * Created by JesusLeon on 15/01/2017.
 */
@Api(name = "galaxy",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "galaxy.ml.com",
                ownerName = "galaxy.ml.com",
                packagePath = ""),
        clientIds = {Constants.WEB_CLIENT_ID})

public class GalaxyApi {
    private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET, path = "clima", name = "clima")
    public Weather getWeatherDay(@Named("dia") int day) {
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Weather");
        Transaction transaction = datastore.newTransaction();
        Entity dayEntity = transaction.get(keyFactory.newKey(day));

        Weather weather = new Weather();
        weather.setDay(day);

        if (dayEntity != null) {
            weather.setWeather(dayEntity.getString("clima"));
        } else {
            BuildGalaxy buildGalaxy = new BuildGalaxy();
            weather.setWeather(buildGalaxy.weatherDay(day, datastore));
        }

        return weather;
    }

    @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET, path = "galaxy", name = "galaxy")
    public GalaxyResponse buildGalaxy(@Named("dias") int days) {
        BuildGalaxy buildGalaxy = new BuildGalaxy();
        buildGalaxy.build(days, datastore);

        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Galaxy");
        Transaction transaction = datastore.newTransaction();
        Entity galaxyEntity = transaction.get(keyFactory.newKey(days));

        GalaxyResponse response = new GalaxyResponse();
        response.setDroughtWeather(galaxyEntity.getLong("num-dias-clima-seco"));
        response.setRainingWeather(galaxyEntity.getLong("num-dias-clima-lluvioso"));
        response.setOptimalWeather(galaxyEntity.getLong("num-dias-optimas-condiciones"));
        response.setMaxRainingDay(galaxyEntity.getLong("dia-que-mas-llovio"));

        return response;
    }
}
