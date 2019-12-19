package pl.mm.adventOfCode.aoc2019.day4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.MainAdventOfCodeRunner2019;

@Component
public class MainSecureContainerPart1 extends MainAdventOfCodeRunner2019 {

    @Autowired
    private NumberOfPossiblePasswordsWithinTheRange numberOfPossiblePasswordsWithinTheRange;

    @Override
    public void run(String[] args) {
        /*int numberLength = 6;
        int startRange = 193651;
        int endRange = 649729;*/

        int result = numberOfPossiblePasswordsWithinTheRange.calculate();

        logger.info("How many different passwords within the range given in your puzzle input meet these criteria?");
        logger.info("Result: '" + result + "'");
    }

}
