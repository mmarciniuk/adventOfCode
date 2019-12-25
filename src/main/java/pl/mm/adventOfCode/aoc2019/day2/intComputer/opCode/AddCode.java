package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public class AddCode extends OpCodeBase {

    public AddCode() {
        super(1, 4);
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        int number1 = getNumber(tableWithCodes, index + 1);
        int number2 = getNumber(tableWithCodes, index + 2);
        int indexForTheResult = findProperIndexForTheResult(tableWithCodes, index + 3);
        tableWithCodes[indexForTheResult] = number1 + number2;
        return tableWithCodes;
    }

}