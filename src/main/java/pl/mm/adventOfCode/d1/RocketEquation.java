package pl.mm.adventOfCode.d1;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RocketEquation {

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
