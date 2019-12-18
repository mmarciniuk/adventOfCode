package pl.mm.adventOfCode.aoc2019.day3;

public enum Direction {

    U("Up"), R("Right"),
    D("Down"), L("Left");

    private String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
