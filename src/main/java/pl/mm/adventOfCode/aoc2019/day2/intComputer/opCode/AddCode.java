package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public class AddCode extends OpCodeBase {

    public AddCode() {
        super(1, 3);
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        int number1 = this.parameterList.get(0).getValue();
        int number2 = this.parameterList.get(1).getValue();
        int indexForTheResult = findProperIndexForTheResult(tableWithCodes, index + 3);
        tableWithCodes[indexForTheResult] = number1 + number2;
        return tableWithCodes;
    }

}
