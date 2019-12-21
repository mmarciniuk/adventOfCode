package pl.mm.adventOfCode.utilities.converter;

import java.util.List;

public interface DoubleConverter extends Converter {

    List<Double> convert(List<String> stringList);

}
