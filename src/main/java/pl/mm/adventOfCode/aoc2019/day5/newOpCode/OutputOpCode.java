package pl.mm.adventOfCode.aoc2019.day5.newOpCode;

import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.OpCodeBase;

public class OutputOpCode extends OpCodeBase {

    private int output = 0;

    public OutputOpCode() {
        super(4, 2);
    }

    public int getOutput() {
        return output;
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        int newIndex = this.findProperIndexForTheResult(tableWithCodes, index + 1);
        this.output = tableWithCodes[newIndex];
        return tableWithCodes;
    }
}
