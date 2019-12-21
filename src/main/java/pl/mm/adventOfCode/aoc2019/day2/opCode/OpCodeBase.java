package pl.mm.adventOfCode.aoc2019.day2.opCode;

public abstract class OpCodeBase implements OpCode {

    protected boolean exit = false;
    protected boolean opCodeExecuted = false;
    protected int opCode;

    protected OpCodeBase(int opCode) {
        this.opCode = opCode;
    }

    @Override
    public boolean isExit() {
        return this.exit;
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

    protected int getNumber(int[] tableWithCodes, int index) {
        int newIndex = tableWithCodes[index];
        if (this.checkIfIndexIsInRangeOfTable(tableWithCodes, newIndex)) {
            return tableWithCodes[newIndex];
        } else {
            return tableWithCodes[index];
        }
    }

    protected int findProperIndexForTheResult(int[] tableWithCodes, int index) {
        int newIndex = tableWithCodes[index];
        if (this.checkIfIndexIsInRangeOfTable(tableWithCodes, newIndex)) {
            return newIndex;
        }
        return index;
    }

}
