package pl.mm.adventOfCode.aoc2019.day6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.MainAdventOfCodeRunner2019;

import java.util.List;

@Component
public class MainUniversalOrbitMapPart1 extends MainAdventOfCodeRunner2019 {

    @Autowired
    private UniversalOrbitMapComputerImpl universalOrbitMapComputer;

    @Override
    public void run(String[] args) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("data/aoc2019/day6/input.txt");
        List<String> stringList = loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());

        int result = universalOrbitMapComputer.calculateNumberOfOrbits(stringList);

        this.logger.info("What is the total number of direct and indirect orbits in your map data?");
        this.logger.info("Result '" + result + "'");

    }

}
