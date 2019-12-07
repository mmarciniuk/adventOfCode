package pl.mm.adventOfCode.aoc2019.day1;

import org.springframework.stereotype.Component;
import pl.mm.adventOfCode.aoc2019.IRocketEquation;

import java.util.List;

@Component
public class RocketEquationDay1 implements IRocketEquation {

    private double totalFuelRequired = 0;

    public double getTotalFuelRequired() {
        return totalFuelRequired;
    }

    public void resetTotalFuelRaredToZero() {
        this.totalFuelRequired = 0;
    }

    public double calculatedRequiredFuelForModuleAndAddToTotal(double mass) {
        double fuelRequiredForModule = Math.floor((mass / 3)) - 2;
        this.totalFuelRequired += fuelRequiredForModule;
        return fuelRequiredForModule;
    }

    public double calculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired(List<Double> doubleList) {
        for (double doubleValue : doubleList) {
            this.calculatedRequiredFuelForModuleAndAddToTotal(doubleValue);
        }
        return this.totalFuelRequired;
    }

}
