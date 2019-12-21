package pl.mm.adventOfCode.aoc2019.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.MainAdventOfCodeRunner2019;

import java.io.IOException;
import java.util.List;

@Component
public class MainTheTyrannyOfTheRocketEquationPart1 extends MainAdventOfCodeRunner2019 {

    @Autowired
    private RocketEquationDay1Part1 rocketEquationDay1;

    @Override
    public void run(String[] args) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("data/aoc2019/day1/input.txt");
        List<String> listOfLoadedLines = this.loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());
        List<Double> listOfModulesMass = this.doubleConverter.convert(listOfLoadedLines);

        double totalFuelRequired = this.rocketEquationDay1.calculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired(listOfModulesMass);
        this.logger.info("Total fuel required for all modules: " + totalFuelRequired);
    }

}
