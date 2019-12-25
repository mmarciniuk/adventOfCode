package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.day2.opCode.AddCode;
import pl.mm.adventOfCode.aoc2019.day2.opCode.ExitCode;
import pl.mm.adventOfCode.aoc2019.day2.opCode.MultipliesCode;
import pl.mm.adventOfCode.aoc2019.day2.opCode.OpCode;

import java.util.Arrays;
import java.util.List;

@Component
public class IntCodeProgramImpl implements IntCodeProgram {

    List<OpCode> opCodeList = Arrays.asList(new ExitCode(), new AddCode(), new MultipliesCode());

    @Override
    public int[] execute(int[] input) {
        int[] result = Arrays.copyOf(input, input.length);
        int incrementer = 4;
        for (int index = 0; index < result.length; index += incrementer) {
            for (OpCode opCode : opCodeList) {
                result = opCode.executeOpCode(result, index);
                if (opCode.isOpCodeExecuted()) {
                    incrementer = opCode.getIncrementer();
                    break;
                }
            }
        }
        return result;
    }

}
