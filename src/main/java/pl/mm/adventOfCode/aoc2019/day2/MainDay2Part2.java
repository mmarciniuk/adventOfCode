package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.MainRunnerBase;
import pl.mm.adventOfCode.helpers.LoadTxtFile;

import java.util.List;

@Component
public class MainDay2Part2 extends MainRunnerBase {

    @Autowired
    private IntCodeProgramImpl intCodeProgram;
    @Autowired
    private LoadTxtFile loadTxtFile;
    @Autowired
    private StringListToIntArrayImpl stringListToIntArray;

    @Override
    public void run(String[] args) throws Exception {
        this.logger.info("*** Day 2: 1202 Program Alarm - PART 2 ***");
        ClassPathResource classPathResource = new ClassPathResource("data/day2/input.txt");
        List<String> stringList = loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());

        int[] input = stringListToIntArray.convert(stringList);
        int[] resultArray;

        int valueToFine = 19690720;
        for (int noun = 0; noun < 99; noun++) {
            for (int verb = 0; verb < 99; verb++) {
                input[1] = noun;
                input[2] = verb;

                resultArray = this.intCodeProgram.execute(input);
                if (resultArray[0] == valueToFine) {
                    int result = 100 * noun + verb;
                    this.logger.info("Result: noun: '" + result + "'");
                    break;
                }

            }
        }

        this.logger.info("*** Day 2: 1202 Program Alarm - PART 2 - ended ***");


    }
}
