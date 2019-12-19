package pl.mm.adventOfCode.aoc2019.day3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class CrossedWiresBase implements CrossedWires {

    protected Point centralPort = new Point();
    protected final Wire wire1 = new Wire();
    protected final Wire wire2 = new Wire();

    protected java.util.List<Point> findCrossingPoints() {
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
