package pl.mm.adventOfCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MainAdventOfCodeRunnerBase implements MainAdventOfCodeRunner {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private int dayNumber = 1;

    @Override
    public void onDayStart(String[] args) {
        this.logger.info("Day " + this.dayNumber + " started");
    }

    @Override
    public void onDayEnd(String[] args) {
        this.logger.info("Day " + this.dayNumber + " ended");
        this.dayNumber++;
    }

    @Override
    public void onYearStart(String[] args) {

    }

    @Override
    public void onYearEnd(String[] args) {

    }
}
