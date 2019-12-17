package pl.mm.adventOfCode.aoc2019.day2;

public interface IntCodeProgram {

    int ADD_CODE = 1;
    int MULTIPLIES_CODE = 2;
    int EXIT_CODE = 99;

    int[] execute(int[] input);

}
