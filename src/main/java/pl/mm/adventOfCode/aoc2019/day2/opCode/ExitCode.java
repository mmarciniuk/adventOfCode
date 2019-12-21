package pl.mm.adventOfCode.aoc2019.day2.opCode;

public class ExitCode extends OpCodeBase {

    public ExitCode() {
        super(99);
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        this.exit = true;
        return tableWithCodes;
    }

}
