package pl.mm.adventOfCode.aoc2019.day3;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class CrossedWiresImpl implements CrossedWires {

    private Point centralPort = new Point();
    private final List<Cable> cableList = new ArrayList<>();

    protected int calculateDistanceBetweenTwoPoints(Point p, Point q) {
        return Math.abs(p.x - q.x) + Math.abs(p.y - q.y);
    }

    private List<Point> getListOfCrossingPoints() {
        List<Point> listOfCrossingPoints = new ArrayList<>();
        for (int i = 0; i < cableList.size(); i++) {
            Cable cable1 = cableList.get(0);
            for (int j = 0; j < cableList.size(); j++) {
                Cable cable2 = cableList.get(j);
                if (i != j && !cable1.equals(cable2)) {
                    listOfCrossingPoints.addAll(findCrossingPoints(cable1, cable2));
                }
            }
        }
        return listOfCrossingPoints;
    }

    private List<Point> findCrossingPoints(Cable cable1, Cable cable2) {
        List<Point> listOfCrossingPoints = new ArrayList<>();
        for (int i = 1; i < cable1.getLayout().size(); i++) {
            Point point1 = cable1.getLayout().get(i);
            for (int j = 1; j < cable2.getLayout().size(); j++) {
                Point point2 = cable2.getLayout().get(j);
                if (point1.equals(point2)) {
                    listOfCrossingPoints.add(new Point(point1));
                }
            }
        }
        return listOfCrossingPoints;
    }

    @Override
    public int calculateMinDistanceToTheCentralPort(List<String> cablePaths) {
        for (String path : cablePaths) {
            cableList.add(new Cable().addLayout(path));
        }

        List<Point> listOfCrossingPoints = getListOfCrossingPoints();

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
