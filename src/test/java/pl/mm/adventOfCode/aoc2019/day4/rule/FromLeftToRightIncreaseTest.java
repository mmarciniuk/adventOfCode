package pl.mm.adventOfCode.aoc2019.day4.rule;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FromLeftToRightIncreaseTest {

    @Test(dataProvider = "testDataProvider")
    public void testCheckIfMeetTheRule(int inputNumber, boolean expectedResult) {
        Rule rule = new FromLeftToRightIncrease();
        boolean actualResult = rule.checkIfMeetTheRule(inputNumber);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][] {
                {1, true},
                {111123, true},
                {135679, true},
                {21, false}
        };
    }

}