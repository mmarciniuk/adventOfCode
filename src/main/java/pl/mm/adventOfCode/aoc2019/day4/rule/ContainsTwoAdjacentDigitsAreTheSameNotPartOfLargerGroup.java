package pl.mm.adventOfCode.aoc2019.day4.rule;

public class ContainsTwoAdjacentDigitsAreTheSameNotPartOfLargerGroup implements Rule {

    @Override
    public boolean checkIfMeetTheRule(int number) {
        int maxGroupSize = 2;
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            int currentGroupSize = 1;
            int digit1 = numberString.charAt(i) - '0';
            for (int j = 0; j < numberString.length(); j++) {
                if (i != j) {
                    int digit2 = numberString.charAt(j) - '0';
                    if (digit1 == digit2) {
                        currentGroupSize++;
                    }
                }
            }
            if (currentGroupSize == maxGroupSize) {
                return true;
            }
        }
        return false;
    }
}
