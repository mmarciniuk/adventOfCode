package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.stereotype.Component;

import java.util.Arrays;

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
        int[] result = Arrays.copyOf(input, input.length);

        for (int i = 0; i < result.length; i += 4) {
            int operationCode = result[i];

            if (EXIT_CODE == operationCode)
                break;

            int number1 = getNumber(result, i + 1);
            int number2 = getNumber(result, i + 2);
            int positionOfResult = getProperPositionOfResultIndex(result, i + 3);

            switch (operationCode) {
                case ADD_CODE:
                    result[positionOfResult] = number1 + number2;
                    break;
                case MULTIPLIES_CODE:
                    result[positionOfResult] = number1 * number2;
                    break;
            }
        }

        return result;
    }

}
