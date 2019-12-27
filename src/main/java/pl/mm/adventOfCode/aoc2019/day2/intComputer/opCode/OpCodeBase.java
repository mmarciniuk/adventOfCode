package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public abstract class OpCodeBase implements OpCode {

    protected final int opCode;
    protected final int incrementer;
    protected boolean opCodeExecuted = false;
    private final static int LENGTH_OF_OPCODE_IN_INSTRUCTION = 2;
    private int numberOfParameters;
    private int[] instructionWithModeForParameters;
    protected final List<Parameter> parameterList = new ArrayList<>();

    public OpCodeBase(int opCode, int numberOfParameters) {
        this.opCode = opCode;
        this.numberOfParameters = numberOfParameters;
        this.incrementer = this.numberOfParameters + 1;
        this.instructionWithModeForParameters = new int[LENGTH_OF_OPCODE_IN_INSTRUCTION + numberOfParameters];
    }

    @Override
    public int getIncrementer() {
        return this.incrementer;
    }

    @Override
    public int getOpCode() {
        return this.opCode;
    }

    @Override
    public boolean isOpCodeExecuted() {
        return this.opCodeExecuted;
    }

    @Override
    public int[] executeOpCode(int[] tableWithCodes, int index) {
        this.setInstructionWithModeForParameters(tableWithCodes, index);
        if (this.getOpCodeFromInstructionWithModeForParameters() == getOpCode()) {
            this.setParameterList(tableWithCodes, index);
            tableWithCodes = delegateExecuteOpCode(tableWithCodes, index);
            this.opCodeExecuted = true;
        } else {
            this.opCodeExecuted = false;
        }
        return tableWithCodes;
    }

    protected boolean checkIfIndexIsInRangeOfTable(int[] tableWithCodes, int index) {
        return index >= 0 && index <= tableWithCodes.length;
    }

    protected int getNumberFromProperIndexOfTable(int[] tableWithCodes, int index) {
        int newIndex = tableWithCodes[index];
        if (this.checkIfIndexIsInRangeOfTable(tableWithCodes, newIndex)) {
            return tableWithCodes[newIndex];
        } else {
            return tableWithCodes[index];
        }
    }

    protected int findProperIndexForTheResult(int[] tableWithCodes, int index) {
        int newIndex = tableWithCodes[index];
        if (this.checkIfIndexIsInRangeOfTable(tableWithCodes, newIndex)) {
            return newIndex;
        }
        return index;
    }

    private void setInstructionWithModeForParameters(int[] tableWithCodes, int index) {
        StringBuilder parameterModesWithOpCode = new StringBuilder(String.valueOf(tableWithCodes[index]));
        int expectedLength = this.numberOfParameters + LENGTH_OF_OPCODE_IN_INSTRUCTION;
        while (parameterModesWithOpCode.length() < expectedLength) {
            parameterModesWithOpCode.insert(0, "0");
        }
        for (int i = 0; i < parameterModesWithOpCode.length(); i++) {
            this.instructionWithModeForParameters[i] = parameterModesWithOpCode.charAt(i) - '0';
        }
    }

    private int getOpCodeFromInstructionWithModeForParameters() {
        String opCode = "";
        opCode += this.instructionWithModeForParameters[this.instructionWithModeForParameters.length - 2];
        opCode += this.instructionWithModeForParameters[this.instructionWithModeForParameters.length - 1];
        return Integer.parseInt(opCode);
    }

    private void setParameterList(int[] tableWithCodes, int index) {
        this.parameterList.clear();
        for (int i = 0; i < this.numberOfParameters; i++) {
            Mode mode = this.getProperModeForParameter(this.instructionWithModeForParameters[i]);
            if (i + 1 == this.numberOfParameters) {
                this.parameterList.add(new ResultParameter(mode, tableWithCodes, index + i + 1));
            } else {
                this.parameterList.add(new ParameterDefault(mode, tableWithCodes, index + i + 1));
            }
        }
    }

    public Mode getProperModeForParameter(int intValue) {
        Mode mode = Mode.POSITION_MODE;
        for (Mode mode1 : EnumSet.allOf(Mode.class)) {
            if (intValue == mode1.getModeNumber()) {
                mode = mode1;
            }
        }
        return mode;
    }

    protected abstract int[] delegateExecuteOpCode(int[] tableWithCodes, int index);

}
