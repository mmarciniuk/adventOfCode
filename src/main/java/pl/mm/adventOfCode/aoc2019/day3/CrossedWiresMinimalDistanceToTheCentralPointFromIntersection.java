package pl.mm.adventOfCode.aoc2019.day3;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class CrossedWiresMinimalDistanceToTheCentralPointFromIntersection extends CrossedWiresBase {

    protected int calculateDistanceBetweenTwoPoints(Point p, Point q) {
        return Math.abs(p.x - q.x) + Math.abs(p.y - q.y);
    }

    @Override
    public int calculate(String pathForWire1, String pathForWire2) {
        this.wire1.addLayout(pathForWire1);
        this.wire2.addLayout(pathForWire2);

        List<Point> listOfCrossingPoints = this.findCrossingPoints();

        List<Integer> integerList = new ArrayList<>();
        for (Point point : listOfCrossingPoints) {
            integerList.add(calculateDistanceBetweenTwoPoints(centralPort, point));
        }
        return integerList.stream()
                .sorted(Comparator.naturalOrder())
                .mapToInt(Integer::intValue)
                .findFirst().orElse(0);
    }

}
