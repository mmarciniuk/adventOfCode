package pl.mm.adventOfCode.aoc2019.day6;

import java.util.List;

public interface UniversalOrbitMapComputer {

    int calculateNumberOfOrbits(List<String> spaceObjectInputMap);

    int numberOfOrbitalTransferFromSourceToDestination(List<String> spaceObjectInputMap, String source, String destination);

}
