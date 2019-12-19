package pl.mm.adventOfCode.aoc2019.day4.rule;

public class ValueWithinTheClosedRange implements Rule {

    private int minValue;
    private int maxValue;

    public ValueWithinTheClosedRange(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean checkIfMeetTheRule(int number) {
        return number >= this.minValue && number <= this.maxValue;
    }


}
