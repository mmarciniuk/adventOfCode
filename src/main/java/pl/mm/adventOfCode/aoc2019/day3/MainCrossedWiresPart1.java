package pl.mm.adventOfCode.aoc2019.day3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.MainAdventOfCodeRunner2019;
import pl.mm.adventOfCode.helpers.LoadTxtFile;

import java.io.IOException;
import java.util.List;

@Component
public class MainCrossedWiresPart1 extends MainAdventOfCodeRunner2019 {

    @Autowired
    private LoadTxtFile loadTxtFile;
    @Autowired
    CrossedWiresMinimalDistanceToTheCentralPointFromIntersection crossedWires;

    @Override
    public void run(String[] args) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("data/aoc2019/day3/input.txt");
        List<String> listOfCablePaths = loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());

        int minDistanceToPort = crossedWires.calculate(listOfCablePaths);

        logger.info("What is the Manhattan distance from the central port to the closest intersection?");
        logger.info("Distance from port to closest intersection = '" + minDistanceToPort + "'");
    }

}
