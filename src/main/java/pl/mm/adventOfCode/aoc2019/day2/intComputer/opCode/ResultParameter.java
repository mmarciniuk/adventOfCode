package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public class ResultParameter extends ParameterBase {

    public ResultParameter(Mode mode, int[] tableWithCodes, int index) {
        super(mode, tableWithCodes, index);
    }

    @Override
    public int getValue() {
        if (this.mode == Mode.POSITION_MODE) {
            int newIndex = tableWithCodes[index];
            if (this.checkIfIndexIsInRangeOfTable(tableWithCodes, newIndex)) {
                return tableWithCodes[newIndex];
            } else {
                return tableWithCodes[index];
            }
        } else {
            return this.index;
        }
    }
}
