package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.stereotype.Component;

@Component
public class IntCodeProgramImpl implements IntCodeProgram {

    private boolean checkIfInArrayRange(int[] array, int index) {
        return index >= 0 && index <= array.length;
    }

    private int getNumber(int[] array, int index) {
        int newIndex = array[index];
        if (this.checkIfInArrayRange(array, newIndex)) {
            return array[newIndex];
        } else {
            return array[index];
        }
    }

    private int getProperPositionOfResultIndex(int[] array, int index) {
        int newIndex = array[index];
        if (this.checkIfInArrayRange(array, newIndex)) {
            return newIndex;
        }
        return index;
    }

    @Override
    public int[] execute(int[] input) {

        for (int i = 0; i < input.length; i += 4) {
            int operationCode = input[i];

            if (EXIT_CODE == operationCode)
                break;

            int number1 = getNumber(input, i + 1);
            int number2 = getNumber(input, i + 2);
            int positionOfResult = getProperPositionOfResultIndex(input, i + 3);

            switch (operationCode) {
                case ADD_CODE:
                    input[positionOfResult] = number1 + number2;
                    break;
                case MULTIPLIES_CODE:
                    input[positionOfResult] = number1 * number2;
                    break;
            }
        }

        return input;
    }

}
