package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public interface OpCode {

    int getOpCode();

    int getIncrementer();

    OpCode setMode(Mode mode);

    int[] executeOpCode(int[] tableWithCodes, int index);

    boolean isOpCodeExecuted();

}
