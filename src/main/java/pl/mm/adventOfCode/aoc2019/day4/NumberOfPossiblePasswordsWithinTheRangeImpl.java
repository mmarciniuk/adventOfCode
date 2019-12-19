package pl.mm.adventOfCode.aoc2019.day4;

import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.day4.rule.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class NumberOfPossiblePasswordsWithinTheRangeImpl implements NumberOfPossiblePasswordsWithinTheRange {

    @SuppressWarnings("FieldCanBeLocal")
    private int numberLength;
    private int startRange;
    private int endRange;
    private List<Rule> ruleList;
    private List<Integer> listOfPossiblePasswords = new ArrayList<>();

    @SuppressWarnings("unused")
    public NumberOfPossiblePasswordsWithinTheRangeImpl() throws Exception {
        this(6, 193651, 649729);
    }

    public NumberOfPossiblePasswordsWithinTheRangeImpl(int numberLength, int startRange, int endRange) throws Exception {
        if (startRange > endRange) {
            throw new Exception("Start range should be lower than end range.");
        }
        this.numberLength = numberLength;
        this.startRange = startRange;
        this.endRange = endRange;

        ruleList = Arrays.asList(
                new MaxNumberLength(this.numberLength),
                new ValueWithinTheClosedRange(this.startRange, this.endRange),
                new TwoAdjacentDigitsAreTheSame(),
                new FromLeftToRightIncrease()
        );
    }

    @Override
    public int calculate() {
        int checkNumber = startRange;
        while (checkNumber != endRange) {
            findPossiblePassword(checkNumber);
            checkNumber++;
        }

        return listOfPossiblePasswords.size();
    }

    private void findPossiblePassword(int checkNumber) {
        boolean whetherAddToListOfPossiblePasswords = true;
        for (Rule rule : ruleList) {
            whetherAddToListOfPossiblePasswords = whetherAddToListOfPossiblePasswords && rule.checkIfMeetTheRule(checkNumber);
        }
        if (whetherAddToListOfPossiblePasswords) {
            listOfPossiblePasswords.add(checkNumber);
        }
    }

}
