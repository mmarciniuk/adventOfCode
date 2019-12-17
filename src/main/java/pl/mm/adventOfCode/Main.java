package pl.mm.adventOfCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Autowired
    private List<MainAdventOfCodeRunner> mainAdventOfCodeRunnerList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        for (MainAdventOfCodeRunner mainAdventOfCodeRunner : this.mainAdventOfCodeRunnerList) {
            try {
                mainAdventOfCodeRunner.onDayStart(args);
                mainAdventOfCodeRunner.run(args);
                mainAdventOfCodeRunner.onYearEnd(args);
            } catch (Exception e) {
                LOGGER.error(e.toString());
            }
        }
    }
}