package pl.mm.adventOfCode.aoc2019.day5.newOpCode;

import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.Mode;
import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.OpCodeBase;
import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.ResultParameter;

public class OutputOpCode extends OpCodeBase {

    private int output = 0;

    public OutputOpCode() {
        super(4, 2, 1);
    }

    public int getOutput() {
        return output;
    }

    @Override
    protected void clearParameterListAndLoadParameters(int[] tableWithCodes, int index) {
        this.parameterList.clear();
        Mode modeParam1 = this.getProperModeForParameter(this.instructionWithModeForParameters[0]);
        this.parameterList.add(new ResultParameter(modeParam1, tableWithCodes, index + 1));
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        int newIndex = this.parameterList.get(0).getValue();
        this.output = tableWithCodes[newIndex];
        return tableWithCodes;
    }
}
