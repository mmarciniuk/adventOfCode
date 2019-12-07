package pl.mm.adventOfCode.aoc2019.day2;

import pl.mm.adventOfCode.helpers.Converter;

import java.util.List;

public interface StringListToIntArray extends Converter {

    int[] convert(List<String> stringList);

}
