package pl.mm.adventOfCode.aoc2019.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.MainAdventOfCodeRunner2019;
import pl.mm.adventOfCode.helpers.LoadTxtFile;

import java.io.IOException;
import java.util.List;

@Component
public class MainTheTyrannyOfTheRocketEquationPart2 extends MainAdventOfCodeRunner2019 {

    @Autowired
    private LoadTxtFile loadTxtFile;
    @Autowired
    private DoubleConverterImpl doubleConverter;
    @Autowired
    private RocketEquationDay1Part2 rocketEquationDay1Part2;

    @Override
    public void run(String[] args) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("data/aoc2019/day1/input.txt");
        List<String> listOfLoadedLines = this.loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());
        List<Double> listOfModulesMass = this.doubleConverter.convert(listOfLoadedLines);

        double totalFuelRequired = this.rocketEquationDay1Part2.calculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired(listOfModulesMass);
        this.logger.info("Total fuel required for all modules: " + totalFuelRequired);
    }

}
