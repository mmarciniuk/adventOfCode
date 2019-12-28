package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public abstract class OpCodeBase implements OpCode {

    protected final int opCode;
    protected final int incrementer;
    protected boolean opCodeExecuted = false;
    private final static int LENGTH_OF_OPCODE_IN_INSTRUCTION = 2;
    protected int numberOfParameters;
    protected int[] instructionWithModeForParameters;
    protected final List<Parameter> parameterList = new ArrayList<>();

    public OpCodeBase(int opCode, int incrementer,  int numberOfParameters) {
        this.opCode = opCode;
        this.numberOfParameters = numberOfParameters;
        this.incrementer = incrementer;
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
            this.clearParameterListAndLoadParameters(tableWithCodes, index);
            tableWithCodes = delegateExecuteOpCode(tableWithCodes, index);
            this.opCodeExecuted = true;
        } else {
            this.opCodeExecuted = false;
        }
        return tableWithCodes;
    }

    protected void setInstructionWithModeForParameters(int[] tableWithCodes, int index) {
        StringBuilder parameterModesWithOpCode = new StringBuilder(String.valueOf(tableWithCodes[index]));
        int expectedLength = this.numberOfParameters + LENGTH_OF_OPCODE_IN_INSTRUCTION;
        while (parameterModesWithOpCode.length() < expectedLength) {
            parameterModesWithOpCode.insert(0, "0");
        }
        for (int i = 0; i < parameterModesWithOpCode.length(); i++) {
            this.instructionWithModeForParameters[i] = parameterModesWithOpCode.charAt(i) - '0';
        }
    }

    protected int getOpCodeFromInstructionWithModeForParameters() {
        String opCode = "";
        opCode += this.instructionWithModeForParameters[this.instructionWithModeForParameters.length - 2];
        opCode += this.instructionWithModeForParameters[this.instructionWithModeForParameters.length - 1];
        return Integer.parseInt(opCode);
    }

    protected abstract void clearParameterListAndLoadParameters(int[] tableWithCodes, int index);

    protected Mode getProperModeForParameter(int intValue) {
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
