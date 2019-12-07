package pl.mm.adventOfCode.aoc2019.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.MainRunnerBase;
import pl.mm.adventOfCode.helpers.LoadTxtFile;

import java.io.IOException;
import java.util.List;

@Component
public class MainDay1Part1 extends MainRunnerBase {

    @Autowired
    private LoadTxtFile loadTxtFile;
    @Autowired
    private DoubleConverterImpl doubleConverter;
    @Autowired
    private RocketEquationDay1Part1 rocketEquationDay1;

    @Override
    public void run(String[] args) throws IOException {
        this.logger.info("*** Day 1: The Tyranny of the Rocket Equation ***");

        ClassPathResource classPathResource = new ClassPathResource("data/day1/input.txt");
        List<String> listOfLoadedLines = this.loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());
        List<Double> listOfModulesMass = this.doubleConverter.convert(listOfLoadedLines);

        double totalFuelRequired = this.rocketEquationDay1.calculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired(listOfModulesMass);
        this.logger.info("Total fuel required: " + totalFuelRequired);

        this.logger.info("*** Day 1: Ended ***");
    }

}
