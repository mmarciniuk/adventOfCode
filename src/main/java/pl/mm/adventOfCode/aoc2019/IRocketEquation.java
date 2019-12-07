package pl.mm.adventOfCode.aoc2019;

import java.util.List;

public interface IRocketEquation {

    double getTotalFuelRequired();

    double calculatedRequiredFuelForModuleAndAddToTotal(double massOfModule);

    double calculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired(List<Double> doubleList);

}
