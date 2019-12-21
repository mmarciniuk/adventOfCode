package pl.mm.adventOfCode.utilities.string;

import pl.mm.adventOfCode.utilities.converter.Converter;

import java.util.List;

public interface StringListToIntArray extends Converter {

    int[] convert(List<String> stringList);

}
