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
    private List<MainRunner> mainRunnerList = new ArrayList<>();

    public static void main(String[] args) {
        LOGGER.info("Advent of Code");
        SpringApplication.run(Main.class, args);
        LOGGER.info("Advent of Code");
    }

    @Override
    public void run(String... args) throws Exception {
        for (MainRunner mainRunner : this.mainRunnerList) {
            mainRunner.run(args);
        }
    }
}