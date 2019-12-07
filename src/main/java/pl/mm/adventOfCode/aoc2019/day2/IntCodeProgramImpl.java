package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class IntCodeProgramImpl implements IntCodeProgram {

    private int[] convertToIntTable(String[] stringArray) {
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    @Override
    public String execute(String input) {
        int[] intArrayInput = this.convertToIntTable(input.split(","));

        for (int i = 0; i < intArrayInput.length; i += 4) {
            int operationCode = intArrayInput[i];

            if (EXIT_CODE == operationCode)
                break;

            int number1 = intArrayInput[i + 1];
            int number2 = intArrayInput[i + 2];
            int positionOfResult = i + 3;

            switch (operationCode) {
                case ADD_CODE:
                    intArrayInput[positionOfResult] = number1 + number2;
                    break;
                case MULTIPLIES_CODE:
                    intArrayInput[positionOfResult] = number1 * number2;
                    break;
            }
        }

        return Arrays.toString(intArrayInput)
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .trim();
    }

}
