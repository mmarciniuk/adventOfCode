package pl.mm.adventOfCode.helpers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoubleConverterImpl implements DoubleConverter {

    @Override
    public List<Double> convertValues(List<String> stringList) {
        List<Double> doubleList = new ArrayList<>();
        for (String line : stringList) {
            try {
                doubleList.add(Double.parseDouble(line));
            }catch (Exception ignore){
            }
        }
        return doubleList;
    }

}
