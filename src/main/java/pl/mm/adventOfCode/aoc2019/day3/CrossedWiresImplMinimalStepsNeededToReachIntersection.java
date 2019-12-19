package pl.mm.adventOfCode.aoc2019.day3;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class CrossedWiresImplMinimalStepsNeededToReachIntersection extends CrossedWiresBase {

    private int calculateMinimalStepsToIntersection(List<Point> listOfCrossingPoints) {
        List<Integer> integerList = new ArrayList<>();
        for (Point crossingPoint : listOfCrossingPoints) {
            int minimalSteps = calculateMinimalStepsToPoint(wire1, crossingPoint);
            minimalSteps += calculateMinimalStepsToPoint(wire2, crossingPoint);
            integerList.add(minimalSteps);
        }
        return integerList.stream()
                .sorted(Comparator.naturalOrder())
                .mapToInt(Integer::intValue)
                .findFirst().orElse(0);
    }

    private int calculateMinimalStepsToPoint(Wire wire, Point stopPoint) {
        int minimalSteps = 0;
        for (Point wirePoint : wire.getLayout()) {
            if (wirePoint.equals(stopPoint)) {
                break;
            }
            minimalSteps++;
        }
        return minimalSteps;
    }

    @Override
    public int calculate(String pathForWire1, String pathForWire2) {
        this.wire1.addLayout(pathForWire1);
        this.wire2.addLayout(pathForWire2);

        List<Point> listOfCrossingPoints = this.findCrossingPoints();

        return calculateMinimalStepsToIntersection(listOfCrossingPoints);
    }

}
