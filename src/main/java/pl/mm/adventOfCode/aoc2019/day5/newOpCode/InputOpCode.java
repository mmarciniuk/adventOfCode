package pl.mm.adventOfCode.aoc2019.day5.newOpCode;

import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.OpCodeBase;

public class InputOpCode extends OpCodeBase {

    private int input;

    public InputOpCode(int input) {
        super(3, 1);
        this.input = input;
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        int newIndex = findProperIndexForTheResult(tableWithCodes, index + 1);
        tableWithCodes[newIndex] = this.input;
        return tableWithCodes;
    }
}
