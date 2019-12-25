package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public class ExitCode extends OpCodeBase {

    public ExitCode() {
        super(99);
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        this.incrementer += tableWithCodes.length;
        return tableWithCodes;
    }

}
