package pl.mm.adventOfCode.aoc2019.day3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cable {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<Point> layout = new ArrayList<>(Collections.singleton(new Point()));
    private int length = 0;

    public List<Point> getLayout() {
        return layout;
    }

    public int getLength() {
        return length;
    }

    private int getLengthOfCabalToAdd(String directionFromTable) {
        return Integer.parseInt(directionFromTable.substring(1));
    }

    private void addLayout(Point point) {
        this.length++;
        this.layout.add(new Point(point));
    }

    public Cable addLayout(String pathOfCable) {
        return this.addLayout(pathOfCable.split(","));
    }

    public Cable addLayout(String[] pathOfCable) {
        Point point = new Point();
        for (String direction : pathOfCable) {
            int lengthOfCabalToAdd = this.getLengthOfCabalToAdd(direction);
            direction = String.valueOf(direction.charAt(0));
            int distance = 0;

            switch (Direction.valueOf(direction)) {
                case U:
                    while (distance < lengthOfCabalToAdd) {
                        distance++;
                        point.y++;
                        this.addLayout(point);
                    }
                    break;
                case R:
                    while (distance < lengthOfCabalToAdd) {
                        distance++;
                        point.x++;
                        this.addLayout(point);
                    }
                    break;
                case D:
                    while (distance < lengthOfCabalToAdd) {
                        distance++;
                        point.y--;
                        this.addLayout(point);
                    }
                    break;
                case L:
                    while (distance < lengthOfCabalToAdd) {
                        distance++;
                        point.x--;
                        this.addLayout(point);
                    }
                    break;
            }
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cable cable = (Cable) o;
        return length == cable.length &&
                layout.equals(cable.layout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(layout, length);
    }
}
