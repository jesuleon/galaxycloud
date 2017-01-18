package com.ml.core;

import com.ml.util.GeometricUtil;

/**
 * Created by JesusLeon on 18/01/2017.
 */
public class Galaxy {
    private Sun sun;
    private Planet ferengi;
    private Planet betasoide;
    private Planet vulcano;

    public Galaxy() {
        this.sun = new Sun();
        this.ferengi =  new Planet(new Double(sun.getPoint().getX()).intValue(),
                new Double(sun.getPoint().getY()).intValue(), 500, 1);

        this.betasoide = new Planet(new Double(sun.getPoint().getX()).intValue(),
                new Double(sun.getPoint().getY()).intValue(), 2000, 3);

        this.vulcano = new Planet(new Double(sun.getPoint().getX()).intValue(),
                new Double(sun.getPoint().getY()).intValue(), 1000, -5);
    }

    public Sun getSun() {
        return sun;
    }

    public Planet getFerengi() {
        return ferengi;
    }

    public Planet getBetasoide() {
        return betasoide;
    }

    public Planet getVulcano() {
        return vulcano;
    }

    public boolean isDroughtWeather(double delta) {
        return GeometricUtil.sameSlope(ferengi.getPoint(), betasoide.getPoint(), vulcano.getPoint(),
                sun.getPoint(), delta);
    }

    public boolean isOptimalConditions(double delta) {
        return GeometricUtil.pointDifferentSlope(ferengi.getPoint(), betasoide.getPoint(), vulcano.getPoint(),
                sun.getPoint(), delta);
    }

    public boolean isRainingWeather() {
        return GeometricUtil.pointInTriangle(sun.getPoint(), ferengi.getPoint(), betasoide.getPoint(),
                vulcano.getPoint());
    }

    public double perimeter() {
        return GeometricUtil.distance(ferengi.getPoint(), betasoide.getPoint())
                + GeometricUtil.distance(betasoide.getPoint(), vulcano.getPoint())
                + GeometricUtil.distance(ferengi.getPoint(), vulcano.getPoint());
    }

    public void simulateDay(int day) {
        ferengi.simulateDay(day);
        betasoide.simulateDay(day);
        vulcano.simulateDay(day);
    }
}
