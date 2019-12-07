package pl.mm.adventOfCode.aoc2019.day1;

import java.util.List;

public interface IRocketEquation {

    double calculatedRequiredFuelForModuleAndAddToTotal(double massOfModule);

    double calculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired(List<Double> doubleList);

}
