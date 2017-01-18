package com.ml.util;

/**
 * Created by JesusLeon on 18/01/2017.
 */
public class GeometricUtil {
    public static final double DELTA = 0.1;

    private enum ORIENTATION {
        POSITIVE, NEGATIVE
    }

    public static double slope(Point p1, Point p2) {
        return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    }

    public static boolean sameSlope(Point p1, Point p2, Point p3, Point p4) {
        return sameSlope(p1, p2, p3, p4, DELTA);
    }

    public static boolean sameSlope(Point p1, Point p2, Point p3, Point p4, double delta) {
        double m12 = GeometricUtil.slope(p1, p2);
        double m23 = GeometricUtil.slope(p2, p3);
        double m34 = GeometricUtil.slope(p3, p4);

        if (Math.abs(m12 - m23) < delta && Math.abs(m23 - m34) < delta) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean pointDifferentSlope(Point p1, Point p2, Point p3, Point pt) {
        return pointDifferentSlope(p1, p2, p3, pt, DELTA);
    }

    public static boolean pointDifferentSlope(Point p1, Point p2, Point p3, Point pt, double delta) {
        double m12 = GeometricUtil.slope(p1, p2);
        double m23 = GeometricUtil.slope(p2, p3);
        double m34 = GeometricUtil.slope(p3, pt);

        if (Math.abs(m12 - m23) < delta && Math.abs(m23 - m34) >= delta) {
            return true;
        } else {
            return false;
        }
    }

    public static ORIENTATION orientation(Point p1, Point p2, Point p3) {
        if ((p1.getX() - p3.getX()) * (p2.getY() - p3.getY())
                - (p1.getY() - p3.getY()) * (p2.getX() - p3.getX()) >= 0) {
            return ORIENTATION.POSITIVE;
        } else {
            return ORIENTATION.NEGATIVE;
        }
    }

    public static boolean pointInTriangle(Point pt, Point v1, Point v2, Point v3) {
        ORIENTATION planetsOrientation = orientation(v1, v2, v3);

        return (planetsOrientation.equals(orientation(v1, v2, pt))
                && planetsOrientation.equals(orientation(v1, pt, v3))
                && planetsOrientation.equals(orientation(pt, v2, v3)));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2.0) + Math.pow(p2.getY() - p1.getY(), 2.0));
    }
}
