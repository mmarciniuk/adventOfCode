package pl.mm.adventOfCode.aoc2019.day1;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RocketEquationDay1Part2 implements RocketEquation {

    @Override
    public double calculatedRequiredFuelForModuleAndAddToTotal(double massOfModule) {
        double fuelRequiredForModule = Math.floor((massOfModule / 3)) - 2;
        if (fuelRequiredForModule < 0)
            fuelRequiredForModule = 0;
        if (fuelRequiredForModule > 0)
            fuelRequiredForModule += this.calculatedRequiredFuelForModuleAndAddToTotal(fuelRequiredForModule);
        return fuelRequiredForModule;
    }

    @Override
    public double calculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired(List<Double> doubleList) {
        double totalFuelRequired = 0;
        for (double fuelRequiredForModule : doubleList) {
            totalFuelRequired += this.calculatedRequiredFuelForModuleAndAddToTotal(fuelRequiredForModule);
        }
        return totalFuelRequired;
    }
}
