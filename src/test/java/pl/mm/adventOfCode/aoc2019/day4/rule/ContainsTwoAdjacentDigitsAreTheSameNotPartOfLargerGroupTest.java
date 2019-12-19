package pl.mm.adventOfCode.aoc2019.day4.rule;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContainsTwoAdjacentDigitsAreTheSameNotPartOfLargerGroupTest {

    @Test(dataProvider = "testDataProvider")
    public void testCheckIfMeetTheRule(int inputNumber, boolean expectedResult) {
        Rule rule = new ContainsTwoAdjacentDigitsAreTheSameNotPartOfLargerGroup();
        boolean actualResult = rule.checkIfMeetTheRule(inputNumber);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][] {
                {112233, true},
                {123444, false},
                {111122, true}
        };
    }

}