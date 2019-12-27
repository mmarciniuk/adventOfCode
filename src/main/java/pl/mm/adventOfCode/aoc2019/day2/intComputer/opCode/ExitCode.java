package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public class ExitCode extends OpCodeBase {

    private boolean exit = false;

    public ExitCode() {
        super(99, 0);
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        this.exit = true;
        return tableWithCodes;
    }

    public boolean isExit() {
        return this.exit;
    }

}
