package pl.mm.adventOfCode.aoc2019.day4;

import java.util.ArrayList;
import java.util.List;

public class NumberOfPossiblePasswordsWithinTheRangeImpl implements NumberOfPossiblePasswordsWithinTheRange {

    private List<Integer> listOfPossiblePasswords = new ArrayList<>();




    @Override
    public int calculate(int startRage, int endRange) throws Exception {
        if (startRage > endRange) {
            throw new Exception("Start range should be lower than end range.");
        }

        while (startRage != endRange) {
            checkIfMeetCriteria(startRage, endRange);
            startRage++;
        }

        return 0;
    }

    private void checkIfMeetCriteria(int startRage, int endRange) {

    }
}
