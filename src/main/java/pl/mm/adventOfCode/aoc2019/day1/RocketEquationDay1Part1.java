package pl.mm.adventOfCode.aoc2019.day1;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RocketEquationDay1Part1 implements IRocketEquation {

    private double totalFuelRequired = 0;

    public double getTotalFuelRequired() {
        return totalFuelRequired;
    }

    public void resetTotalFuelRaredToZero() {
        this.totalFuelRequired = 0;
    }

    @Override
    public double calculatedRequiredFuelForModuleAndAddToTotal(double massOfModule) {
        double fuelRequiredForModule = Math.floor((massOfModule / 3)) - 2;
        this.totalFuelRequired += fuelRequiredForModule;
        return fuelRequiredForModule;
    }

    @Override
    public double calculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired(List<Double> doubleList) {
        for (double doubleValue : doubleList) {
            this.calculatedRequiredFuelForModuleAndAddToTotal(doubleValue);
        }
        return this.totalFuelRequired;
    }

}
