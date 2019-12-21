package pl.mm.adventOfCode.aoc2019.day2.opCode;

public interface OpCode {

    boolean isExit();

    int getOpCode();

    int[] executeOpCode(int[] tableWithCodes, int index);

    boolean isOpCodeExecuted();

}
