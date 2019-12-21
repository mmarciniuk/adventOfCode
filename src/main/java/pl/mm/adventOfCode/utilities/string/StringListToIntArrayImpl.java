package pl.mm.adventOfCode.utilities.string;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StringListToIntArrayImpl implements StringListToIntArray {

    @Override
    public int[] convert(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();

        for (String line : stringList) {
            String[] stringArray = line.split(",");
            for (String element : stringArray) {
                element = element.trim();
                integerList.add(Integer.valueOf(element));
            }
        }

        return integerList.stream().mapToInt(i -> i).toArray();
    }

}
