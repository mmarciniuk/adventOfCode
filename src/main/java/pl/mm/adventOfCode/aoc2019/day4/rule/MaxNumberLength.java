package pl.mm.adventOfCode.aoc2019.day4.rule;

public class MaxNumberLength implements Rule {

    private int maxNumberLength;

    public MaxNumberLength(int maxNumberLength) {
        this.maxNumberLength = maxNumberLength;
    }

    @Override
    public boolean checkIfMeetTheRule(int number) {
        return String.valueOf(number).length() == this.maxNumberLength;
    }

}
