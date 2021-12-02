package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class Segment {
    Point start, end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException("Start and end points are equal");
        }
    }

    double length() {
        double distanceX = StrictMath.pow(start.getX() - end.getX(), 2);
        double distanceY = StrictMath.pow(start.getY() - end.getY(), 2);
        return Math.sqrt(distanceX + distanceY);
    }

    public Point middle() {
        double x = (start.getX() + end.getX()) / 2;
        double y = (start.getY() + end.getY()) / 2;
        return new Point(x, y);
    }

    public Point intersection(Segment another) {
        double x1 = start.getX();
        double x2 = end.getX();
        double x3 = another.start.getX();
        double x4 = another.end.getX();
        double y1 = start.getY();
        double y2 = end.getY();
        double y3 = another.start.getY();
        double y4 = another.end.getY();

        double d = ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        if (d != 0) {
            double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / d;
            double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / d;
            if ((0.0 <= t && t <= 1.0) && (0 <= u && u <= 1)) {
                double x = x1 + t * (x2 - x1);
                double y = y1 + t * (y2 - y1);
                return new Point(x, y);
            } else {
                return null;
            }
        } else return null;


    }

}
