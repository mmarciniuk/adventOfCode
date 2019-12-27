package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public abstract class ParameterBase implements Parameter {

    protected final Mode mode;
    protected final int[] tableWithCodes;
    protected final int index;

    protected ParameterBase(Mode mode, int[] tableWithCodes, int index) {
        this.mode = mode;
        this.tableWithCodes = tableWithCodes;
        this.index = index;
    }

    protected boolean checkIfIndexIsInRangeOfTable(int[] tableWithCodes, int index) {
        return index < 0 || index > tableWithCodes.length;
    }

    @Override
    public Mode getMode() {
        return this.mode;
    }

}
