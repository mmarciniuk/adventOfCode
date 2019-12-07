package pl.mm.adventOfCode.aoc2019.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.mm.adventOfCode.BaseTest;

@SpringBootTest(classes = {RocketEquationDay1Part1.class})
public class RocketEquationDay1Part1Test extends BaseTest {

    @Autowired
    private RocketEquationDay1Part1 rocketEquationDay1;

    @Test(dataProvider = "dataProvider")
    public void testCalculatedRequiredFlue(double mass, double correctResult) {
        double actualResult = rocketEquationDay1.calculatedRequiredFuelForModuleAndAddToTotal(mass);
        Assert.assertEquals(actualResult, correctResult);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {12d, 2d},
                {14d, 2d},
                {1969d, 654d},
                {100756d, 33583d}
        };
    }


}