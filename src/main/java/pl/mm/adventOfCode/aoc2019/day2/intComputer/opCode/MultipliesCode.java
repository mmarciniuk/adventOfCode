package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public class MultipliesCode extends OpCodeBase {

    public MultipliesCode() {
        super(2, 4);
    }

    @Override
    protected int[] delegateExecuteOpCode(int[] tableWithCodes, int index) {
        int number1 = getNumberFromProperIndexOfTable(tableWithCodes, index + 1);
        int number2 = getNumberFromProperIndexOfTable(tableWithCodes, index + 2);
        int indexForTheResult = findProperIndexForTheResult(tableWithCodes, index + 3);
        tableWithCodes[indexForTheResult] = number1 * number2;
        return tableWithCodes;
    }

}
