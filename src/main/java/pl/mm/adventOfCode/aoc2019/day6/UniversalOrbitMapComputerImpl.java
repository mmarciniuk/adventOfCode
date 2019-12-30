package pl.mm.adventOfCode.aoc2019.day6;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class UniversalOrbitMapComputerImpl implements UniversalOrbitMapComputer {

    @SuppressWarnings("FieldCanBeLocal")
    private final String spaceObjectSeparator = "\\)";
    private final SpaceObjectListMap<String, String> spaceObjectListMap = new SpaceObjectListMap<>();

    private void setSpaceObjectListMap(List<String> spaceObjectInputMap) {
        this.spaceObjectListMap.clear();

        for (String elementFromInput : spaceObjectInputMap) {
            String[] spaceObjectFromInput = elementFromInput.split(this.spaceObjectSeparator);
            this.spaceObjectListMap.addSpaceObject(spaceObjectFromInput[0], spaceObjectFromInput[1]);
        }
    }

    @Override
    public int calculateNumberOfOrbits(List<String> spaceObjectInputMap) {
        this.setSpaceObjectListMap(spaceObjectInputMap);

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

    @Override
    public int numberOfOrbitalTransferFromSourceToDestination(List<String> spaceObjectInputMap,
                                                              String source, String destination) {
        this.setSpaceObjectListMap(spaceObjectInputMap);
        return numberOfOrbitalTransferFromSourceToDestination(source, destination, new ArrayList<>(), 0);
    }

    private int numberOfOrbitalTransferFromSourceToDestination(String source, String destination,
                                                               ArrayList<String> visitedSpaceObject, int counter) {
        if (visitedSpaceObject.contains(source))
            return 0;
        visitedSpaceObject.add(source);
        List<String> str = collectAll(source);
        if (str.contains(destination))
            return counter - 1;
        for (String s : str) {
            int findRoute = numberOfOrbitalTransferFromSourceToDestination(s, destination, visitedSpaceObject, counter + 1);
            if (findRoute > 0) return findRoute;
        }
        return -1;
    }

    private List<String> collectAll(String s1) {
        List<String> s = findOrbit(s1);
        s.addAll(this.spaceObjectListMap.get(s1));
        return s;
    }

    private List<String> findOrbit(String orbitValue) {
        return this.spaceObjectListMap.entrySet().stream()
                .filter(e -> e.getValue().contains(orbitValue))
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }


}
