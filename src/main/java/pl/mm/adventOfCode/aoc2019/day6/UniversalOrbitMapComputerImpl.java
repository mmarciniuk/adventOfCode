package pl.mm.adventOfCode.aoc2019.day6;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UniversalOrbitMapComputerImpl implements UniversalOrbitMapComputer {

    private final String spaceObjectSeparator = "\\)";
    private final SpaceObjectListMap<String, String> spaceObjectListMap = new SpaceObjectListMap<>();

    @Override
    public int calculateNumberOfOrbits(List<String> spaceObjectInputMap) {
        this.spaceObjectListMap.clear();

        for (String elementFromInput : spaceObjectInputMap) {
            String[] spaceObjectFromInput = elementFromInput.split(this.spaceObjectSeparator);
            this.spaceObjectListMap.addSpaceObject(spaceObjectFromInput[0], spaceObjectFromInput[1]);
        }

        AtomicInteger numberOfOrbits = new AtomicInteger();
        for (Map.Entry<String, List<String>> entry : this.spaceObjectListMap.entrySet()) {
            this.calculateTotalNumberOfOrbits(this.spaceObjectListMap, numberOfOrbits, entry.getValue());
        }

        return numberOfOrbits.get();
    }

    private void calculateTotalNumberOfOrbits(SpaceObjectListMap<String, String> spaceObjectListMap, AtomicInteger counter, List<String> entry) {
        for (String entry2 : entry) {
            counter.incrementAndGet();
            if (spaceObjectListMap.containsKey(entry2)) {
                this.calculateTotalNumberOfOrbits(spaceObjectListMap, counter, spaceObjectListMap.get(entry2));
            }
        }
    }

}
