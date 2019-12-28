package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public class AddCode extends OpCodeBase {

    public AddCode() {
        super(1, 4, 3);
    }

    @Override
    protected void clearParameterListAndLoadParameters(int[] tableWithCodes, int index) {
        this.parameterList.clear();

        Mode modeParam1 = this.getProperModeForParameter(this.instructionWithModeForParameters[0]);
        this.parameterList.add(new ParameterDefault(modeParam1, tableWithCodes, index + 1));

        Mode modeParam2 = this.getProperModeForParameter(this.instructionWithModeForParameters[1]);
        this.parameterList.add(new ParameterDefault(modeParam2, tableWithCodes, index + 2));

        Mode modeParamResult = this.getProperModeForParameter(this.instructionWithModeForParameters[2]);
        this.parameterList.add(new ResultParameter(modeParamResult, tableWithCodes, index + 3));
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        int number1 = this.parameterList.get(0).getValue();
        int number2 = this.parameterList.get(1).getValue();
        tableWithCodes[this.parameterList.get(2).getValue()] = number1 + number2;
        return tableWithCodes;
    }

}
