package pl.mm.adventOfCode.aoc2019.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpaceObjectListMap<S1, S2> extends HashMap<S1, List<S2>> {

    @SuppressWarnings("UnusedReturnValue")
    public List<S2> addSpaceObject(S1 key, S2 value) {
        List<S2> list;
        if (super.containsKey(key)) {
            list = super.get(key);
        } else {
            list = new ArrayList<>();
        }
        list.add(value);
        return super.put(key, list);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<S2> get(Object key) {
        if (!super.containsKey(key))
            super.put((S1) key, new ArrayList<>());
        return super.get(key);
    }

}
