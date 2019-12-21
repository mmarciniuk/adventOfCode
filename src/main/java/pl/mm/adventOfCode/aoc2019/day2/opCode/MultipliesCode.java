package pl.mm.adventOfCode.aoc2019.day2.opCode;

public class MultipliesCode extends OpCodeBase {

    public MultipliesCode() {
        super(2);
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        int number1 = getNumber(tableWithCodes, index + 1);
        int number2 = getNumber(tableWithCodes, index + 2);
        int indexForTheResult = findProperIndexForTheResult(tableWithCodes, index + 3);
        tableWithCodes[indexForTheResult] = number1 * number2;
        return tableWithCodes;
    }

}
