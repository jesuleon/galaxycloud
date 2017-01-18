package com.ml.core;

import com.ml.util.Point;

/**
 * Created by JesusLeon on 14/01/2017.
 */
public class Planet {
    private Point point;

    /**
     * Rotation grade in a day
     */
    private int rotationGrade;

    /**
     * Distance to the sun
     */
    private int radio;

    public Planet(int x, int y, int radio, int rotationGrade) {
        this.point = new Point(x + radio, y);
        this.radio = radio;
        this.rotationGrade = rotationGrade;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void simulateDay(int day) {
        double a = (rotationGrade * day) * 2 * Math.PI / 360;

        this.getPoint().setX((int) (radio * Math.cos(a)));
        this.getPoint().setY((int) (radio * Math.sin(a)));

    }
}
