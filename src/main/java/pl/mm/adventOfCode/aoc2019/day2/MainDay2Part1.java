package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.MainRunnerBase;
import pl.mm.adventOfCode.helpers.LoadTxtFile;

import java.util.Arrays;
import java.util.List;

@Component
public class MainDay2Part1 extends MainRunnerBase {

    @Autowired
    private IntCodeProgramImpl intCodeProgram;
    @Autowired
    private LoadTxtFile loadTxtFile;
    @Autowired
    private StringListToIntArrayImpl stringListToIntArray;

    @Override
    public void run(String[] args) throws Exception {
        this.logger.info("*** Day 2: 1202 Program Alarm ***");
        ClassPathResource classPathResource = new ClassPathResource("data/day2/input.txt");
        List<String> stringList = loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());

        int[] input = stringListToIntArray.convert(stringList);
        input[1] = 12;
        input[2] = 2;

        int[] result = this.intCodeProgram.execute(input);

        this.logger.info("Result: '" + result[0] + "'");

        this.logger.info("*** Day 2: 1202 Program Alarm - ended ***");
    }

}
