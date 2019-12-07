package pl.mm.adventOfCode.aoc2019.day2;

public interface IntCodeProgram {

    final static int ADD_CODE = 1;
    final static int MULTIPLIES_CODE = 2;
    final static int EXIT_CODE = 99;

    String execute(String input);

}
