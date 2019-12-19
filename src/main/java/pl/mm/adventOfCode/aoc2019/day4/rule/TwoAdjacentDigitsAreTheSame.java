package pl.mm.adventOfCode.aoc2019.day4.rule;

public class TwoAdjacentDigitsAreTheSame implements Rule {

    @Override
    public boolean checkIfMeetTheRule(int number) {
        String numberString = String.valueOf(number);
        for (int i = 1; i < numberString.length(); i++) {
            int digit1 = numberString.charAt(i - 1) - '0';
            int digit2 = numberString.charAt(i) - '0';
            if (digit1 == digit2) {
                return true;
            }
        }
        return false;
    }

}
