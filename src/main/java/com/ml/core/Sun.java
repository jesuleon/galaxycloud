package com.ml.core;

import com.ml.util.Point;

/**
 * Created by JesusLeon on 14/01/2017.
 */
public class Sun {

    private Point point;

    public Sun() {
        this(0, 0);
    }

    private Sun(int x, int y) {
        point = new Point(x, y);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
