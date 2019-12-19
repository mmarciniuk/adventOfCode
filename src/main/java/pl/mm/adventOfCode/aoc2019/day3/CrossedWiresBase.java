package pl.mm.adventOfCode.aoc2019.day3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class CrossedWiresBase implements CrossedWires {

    protected Point centralPort = new Point();
    protected final List<Wire> wireList = new ArrayList<>();

    protected java.util.List<Point> iterateOverTheCablesAndFindCrossingPoints() {
        java.util.List<Point> listOfCrossingPoints = new ArrayList<>();
        for (int i = 0; i < wireList.size(); i++) {
            Wire wire1 = wireList.get(0);
            for (int j = 0; j < wireList.size(); j++) {
                Wire wire2 = wireList.get(j);
                if (i != j && !wire1.equals(wire2)) {
                    listOfCrossingPoints.addAll(findCrossingPoints(wire1, wire2));
                }
            }
        }
        return listOfCrossingPoints;
    }

    protected java.util.List<Point> findCrossingPoints(Wire wire1, Wire wire2) {
        List<Point> listOfCrossingPoints = new ArrayList<>();
        for (int i = 1; i < wire1.getLayout().size(); i++) {
            Point point1 = wire1.getLayout().get(i);
            for (int j = 1; j < wire2.getLayout().size(); j++) {
                Point point2 = wire2.getLayout().get(j);
                if (point1.equals(point2)) {
                    listOfCrossingPoints.add(new Point(point1));
                }
            }
        }
        return listOfCrossingPoints;
    }

}
