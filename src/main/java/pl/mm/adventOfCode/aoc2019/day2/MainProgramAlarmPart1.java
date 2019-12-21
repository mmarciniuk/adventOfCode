package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.MainAdventOfCodeRunner2019;
import pl.mm.adventOfCode.utilities.string.StringListToIntArrayImpl;

import java.util.List;

@Component
public class MainProgramAlarmPart1 extends MainAdventOfCodeRunner2019 {

    @Autowired
    private IntCodeProgram intCodeProgram;
    @Autowired
    private StringListToIntArrayImpl stringListToIntArray;

    @Override
    public void run(String[] args) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("data/aoc2019/day2/input.txt");
        List<String> stringList = loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());

        int[] input = stringListToIntArray.convert(stringList);
        input[1] = 12;
        input[2] = 2;

        int[] result = this.intCodeProgram.execute(input);

        this.logger.info("Result: '" + result[0] + "'");
    }

}
