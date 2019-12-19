package pl.mm.adventOfCode.aoc2019.day4;

import pl.mm.adventOfCode.aoc2019.day4.rule.Rule;

public interface NumberOfPossiblePasswordsWithinTheRange {

    NumberOfPossiblePasswordsWithinTheRange addRule(Rule rule);

    int calculate(int startRange, int endRange);

}
