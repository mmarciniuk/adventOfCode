package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProgramAlarm1202Impl implements ProgramAlarm1202 {

    private String add(int number1, int number2) {
        return String.valueOf(number1 + number2);
    }

    private String multiply(int number1, int number2) {
        return String.valueOf(number1 * number2);
    }

    private int getNumberForTheCorrectPosition(String[] tableOfInputs, int iteration) {
        int result;
        if (iteration < tableOfInputs.length){
            result =Integer.parseInt(tableOfInputs[iteration]);
            if (result > 0 && result < tableOfInputs.length) {
                result = this.getNumberForTheCorrectPosition(tableOfInputs, result);
            }
        } else {
            result = iteration;
        }
        return result;
    }

    private int getPositionForTheResult(String[] tableOfInputs, int iteration) {
        int result = iteration;
        if (iteration < tableOfInputs.length) {
            result = Integer.parseInt(tableOfInputs[iteration]);
            if (result > tableOfInputs.length) {
                result = iteration;
            }
        }
        return result;
    }

    private void executeOperation(String[] tableOfInputs, String operationCode,
                                  int number1, int number2, int positionOfResult) {
        if (operationCode.equals(EXIT_CODE))
            return;

        switch (operationCode) {
            case ADD_CODE:
                tableOfInputs[positionOfResult] = this.add(number1, number2);
                break;
            case MULTIPLIES_CODE:
                tableOfInputs[positionOfResult] = this.multiply(number1, number2);
                break;
        }
    }

    @Override
    public String execute(String input) {
        String[] tableOfInputs = input.split(",");

        for (int i = 0; i < tableOfInputs.length; i += 4) {
            String operationCode = tableOfInputs[i];
            int positionOfNumber1 = getNumberForTheCorrectPosition(tableOfInputs, i + 1);
            int positionOfNumber2 = getNumberForTheCorrectPosition(tableOfInputs, i + 2);
            int positionOfResult = getPositionForTheResult(tableOfInputs, i + 3);

            this.executeOperation(tableOfInputs, operationCode, positionOfNumber1,
                    positionOfNumber2, positionOfResult);
        }

        return Arrays.toString(tableOfInputs)
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .trim();
    }

}
