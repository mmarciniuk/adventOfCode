package pl.mm.adventOfCode.aoc2019.day1;

import pl.mm.adventOfCode.helpers.Converter;

import java.util.List;

public interface DoubleConverter extends Converter {

    List<Double> convert(List<String> stringList);

}
