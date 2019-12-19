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
    public int calculate(List<String> cablePaths) {
        for (String path : cablePaths) {
            wireList.add(new Wire().addLayout(path));
        }

        List<Point> listOfCrossingPoints = iterateOverTheCablesAndFindCrossingPoints();

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
