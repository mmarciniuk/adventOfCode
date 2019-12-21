package pl.mm.adventOfCode.aoc2019.day2v2;

import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.day2v2.opCode.AddCode;
import pl.mm.adventOfCode.aoc2019.day2v2.opCode.ExitCode;
import pl.mm.adventOfCode.aoc2019.day2v2.opCode.MultipliesCode;
import pl.mm.adventOfCode.aoc2019.day2v2.opCode.OpCode;

import java.util.Arrays;
import java.util.List;

@Component
public class IntCodeProgramImpl2 implements IntCodeProgram {

    List<OpCode> opCodeList = Arrays.asList(new ExitCode(), new AddCode(), new MultipliesCode());

    @Override
    public int[] execute(int[] input) {
        int[] result = Arrays.copyOf(input, input.length);
        boolean exit = false;
        for (int index = 0; index < result.length; index += 4) {
            for (OpCode opCode : opCodeList) {
                result = opCode.executeOpCode(result, index);
                exit = opCode.isExit();
                if (opCode.isOpCodeExecuted())
                    break;
            }

            if (exit)
                break;
        }
        return result;
    }

}
