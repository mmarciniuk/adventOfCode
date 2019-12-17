package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.MainAdventOfCodeRunnerBase;
import pl.mm.adventOfCode.helpers.LoadTxtFile;

import java.util.List;

@Component
public class ProgramAlarmPart1 extends MainAdventOfCodeRunnerBase {

    @Autowired
    private IntCodeProgramImpl intCodeProgram;
    @Autowired
    private LoadTxtFile loadTxtFile;
    @Autowired
    private StringListToIntArrayImpl stringListToIntArray;

    @Override
    public void run(String[] args) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("data/day2/input.txt");
        List<String> stringList = loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());

        int[] input = stringListToIntArray.convert(stringList);
        input[1] = 12;
        input[2] = 2;

        int[] result = this.intCodeProgram.execute(input);

        this.logger.info("Result: '" + result[0] + "'");
    }

}
