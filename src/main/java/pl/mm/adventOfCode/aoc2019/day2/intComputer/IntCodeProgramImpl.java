package pl.mm.adventOfCode.aoc2019.day2.intComputer;

import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.AddCode;
import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.ExitCode;
import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.MultipliesCode;
import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.OpCode;

import java.util.Arrays;
import java.util.List;

@Component
public class IntCodeProgramImpl implements IntCodeProgram {

    private List<OpCode> opCodeList = Arrays.asList(new ExitCode(), new AddCode(), new MultipliesCode());

    @Override
    public int[] execute(int[] input) {
        int[] result = Arrays.copyOf(input, input.length);
        int incrementer = 4;
        boolean ifExit = false;
        for (int index = 0; index < result.length; index += incrementer) {
            for (OpCode opCode : opCodeList) {
                result = opCode.executeOpCode(result, index);
                if (opCode.isOpCodeExecuted()) {
                    if (opCode instanceof ExitCode)
                        ifExit = ((ExitCode) opCode).isExit();
                    incrementer = opCode.getIncrementer();
                    break;
                }
            }
            if (ifExit)
                break;
        }
        return result;
    }

}
