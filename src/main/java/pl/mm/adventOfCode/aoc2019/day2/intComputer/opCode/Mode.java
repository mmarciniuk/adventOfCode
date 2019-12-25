package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public enum Mode {

    POSITION_MODE(0), IMMEDIATE_MODE(1);

    private int modeNumber;

    Mode(int modeNumber) {
        this.modeNumber = modeNumber;
    }

}
