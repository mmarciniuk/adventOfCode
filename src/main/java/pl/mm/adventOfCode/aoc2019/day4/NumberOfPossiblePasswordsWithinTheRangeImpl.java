package pl.mm.adventOfCode.aoc2019.day4;

import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.day4.rule.Rule;

import java.util.ArrayList;
import java.util.List;

@Component
public class NumberOfPossiblePasswordsWithinTheRangeImpl implements NumberOfPossiblePasswordsWithinTheRange {

    private List<Rule> ruleList = new ArrayList<>();
    private List<Integer> listOfPossiblePasswords = new ArrayList<>();

    public NumberOfPossiblePasswordsWithinTheRange addRule(Rule rule) {
        ruleList.add(rule);
        return this;
    }

    @Override
    public int calculate(int startRange, int endRange) {
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
