package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public abstract class OpCodeBase implements OpCode {

    protected Mode mode = Mode.POSITION_MODE;
    protected int incrementer = 1;
    protected boolean opCodeExecuted = false;
    protected int opCode;

    protected OpCodeBase(int opCode) {
        this.opCode = opCode;
    }

    protected OpCodeBase(int opCode, int incrementer) {
        this(opCode);
        this.incrementer = incrementer;
    }

    @Override
    public OpCode setMode(Mode mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public int getIncrementer() {
        return this.incrementer;
    }

    @Override
    public int getOpCode() {
        return this.opCode;
    }

    protected abstract int[] delegateExecuteOpCode(int[] tableWithCodes, int index);

    @Override
    public int[] executeOpCode(int[] tableWithCodes, int index) {
        if (tableWithCodes[index] == getOpCode()) {
            this.opCodeExecuted = true;
            tableWithCodes = delegateExecuteOpCode(tableWithCodes, index);
        } else {
            this.opCodeExecuted = false;
        }
        return tableWithCodes;
    }

    @Override
    public boolean isOpCodeExecuted() {
        return this.opCodeExecuted;
    }

    protected boolean checkIfIndexIsInRangeOfTable(int[] tableWithCodes, int index) {
        return index >= 0 && index <= tableWithCodes.length;
    }

    protected int getNumberFromProperIndexOfTable(int[] tableWithCodes, int index) {
        if (this.mode == Mode.POSITION_MODE) {
            int newIndex = tableWithCodes[index];
            if (this.checkIfIndexIsInRangeOfTable(tableWithCodes, newIndex)) {
                return tableWithCodes[newIndex];
            } else {
                return tableWithCodes[index];
            }
        } else {
            return tableWithCodes[index];
        }
    }

    protected int findProperIndexForTheResult(int[] tableWithCodes, int index) {
        if (this.mode == Mode.POSITION_MODE) {
            int newIndex = tableWithCodes[index];
            if (this.checkIfIndexIsInRangeOfTable(tableWithCodes, newIndex)) {
                return newIndex;
            }
            return index;
        } else {
            return index;
        }
    }

}
