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

    @Override
    public void run(String[] args) throws Exception {
        this.logger.info("*** Day 2: 1202 Program Alarm ***");
        ClassPathResource classPathResource = new ClassPathResource("data/day2/input.txt");
        List<String> stringList = loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());

        int[] input = {1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 13, 1, 19, 1, 19, 9, 23, 1, 5, 23, 27, 1, 27, 9, 31, 1, 6, 31, 35, 2, 35, 9, 39, 1, 39, 6, 43, 2, 9, 43, 47, 1, 47, 6, 51, 2, 51, 9, 55, 1, 5, 55, 59, 2, 59, 6, 63, 1, 9, 63, 67, 1, 67, 10, 71, 1, 71, 13, 75, 2, 13, 75, 79, 1, 6, 79, 83, 2, 9, 83, 87, 1, 87, 6, 91, 2, 10, 91, 95, 2, 13, 95, 99, 1, 9, 99, 103, 1, 5, 103, 107, 2, 9, 107, 111, 1, 111, 5, 115, 1, 115, 5, 119, 1, 10, 119, 123, 1, 13, 123, 127, 1, 2, 127, 131, 1, 131, 13, 0, 99, 2, 14, 0, 0};
        input[1] = 12;
        input[2] = 2;

        int[] result = this.intCodeProgram.execute(input);

        this.logger.info("Result: '" + result[0] + "'");

        this.logger.info("*** Day 2: 1202 Program Alarm - ended ***");
    }

}
