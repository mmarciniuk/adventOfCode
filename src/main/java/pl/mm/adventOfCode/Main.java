package pl.mm.adventOfCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import pl.mm.adventOfCode.d1.RocketEquation;
import pl.mm.adventOfCode.helpers.DoubleConverterImpl;
import pl.mm.adventOfCode.helpers.LoadTxtFile;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Autowired
    private LoadTxtFile loadTxtFile;
    @Autowired
    private DoubleConverterImpl doubleConverter;
    @Autowired
    private RocketEquation rocketEquation;

    public static void main(String[] args) {
        LOGGER.info("Application start");
        SpringApplication.run(Main.class, args);
        LOGGER.info("Application finished");
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("EXECUTING : command line runner");
        for (int i = 0; i < args.length; ++i) {
            LOGGER.info("args[{}]: {}", i, args[i]);
        }

        LOGGER.info("Day 1: The Tyranny of the Rocket Equation");
        ClassPathResource classPathResource = new ClassPathResource("data/day1/input.txt");
        List<String> listOfLoadedLines = this.loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());
        List<Double> listOfModulesMass = this.doubleConverter.convertValues(listOfLoadedLines);

        double totalFuelRequired = this.rocketEquation.calculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired(listOfModulesMass);
        LOGGER.info("Total fuel required: " + totalFuelRequired);

    }
}