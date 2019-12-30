package pl.mm.adventOfCode.aoc2019.day6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.MainAdventOfCodeRunner2019;

import java.util.List;

@Component
public class MainUniversalOrbitMapPart2 extends MainAdventOfCodeRunner2019 {

    @Autowired
    private UniversalOrbitMapComputerImpl universalOrbitMapComputer;

    @Override
    public void run(String[] args) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("data/aoc2019/day6/input.txt");
        List<String> stringList = loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());

        int result = universalOrbitMapComputer.numberOfOrbitalTransferFromSourceToDestination(stringList, "YOU", "SAN");

        this.logger.info("What is the minimum number of orbital transfers required to move from the object YOU are orbiting to the object SAN is orbiting? (Between the objects they are orbiting - not between YOU and SAN.)");
        this.logger.info("Result '" + result + "'");
    }

}
