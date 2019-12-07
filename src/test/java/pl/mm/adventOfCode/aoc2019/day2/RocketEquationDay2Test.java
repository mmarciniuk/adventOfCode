package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.mm.adventOfCode.BaseTest;
import pl.mm.adventOfCode.Main;

@SpringBootTest(classes = {Main.class})
public class RocketEquationDay2Test extends BaseTest {

    @Autowired
    private RocketEquationDay2 rocketEquationDay2;

    @Test(dataProvider = "dataProviderForModule")
    public void testCalculatedRequiredFuelForModuleAndAddToTotal(double moduleMass, double expectedFuelRequired) {
        double fuelRequiredForModule = this.rocketEquationDay2.calculatedRequiredFuelForModuleAndAddToTotal(moduleMass);
        Assert.assertEquals(fuelRequiredForModule, expectedFuelRequired);
    }

    @Test
    public void testCalculatedRequiredFuelForAllModuleAndReturnTotalFuelRequired() {
    }

    @DataProvider(name = "dataProviderForModule")
    public Object[][] dataProvider() {
        return new Object[][]{
                {14d, 2d},
                {1969d, 966d},
                {100756d, 50346d}
        };
    }

}