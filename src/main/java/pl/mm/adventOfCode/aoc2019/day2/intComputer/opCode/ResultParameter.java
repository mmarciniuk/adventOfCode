package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

public class ResultParameter extends ParameterBase {

    public ResultParameter(Mode mode, int[] tableWithCodes, int index) {
        super(mode, tableWithCodes, index);
    }

    @Override
    public int getValue() {
        if (this.mode == Mode.POSITION_MODE) {
            int newIndex = this.tableWithCodes[this.index];
            if (checkIfIndexIsInRangeOfTable(this.tableWithCodes, newIndex)) {
                newIndex = this.index;
            }
            return tableWithCodes[newIndex];
        } else {
            return this.index;
        }
    }
}
