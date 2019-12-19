package pl.mm.adventOfCode.aoc2019.day4.rule;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MaxNumberLengthTest {

    @Test(dataProvider = "testDataProvider")
    public void testCheckIfMeetTheRule(int maxNumberLength, int inputNumber, boolean expectedResult) {
        Rule rule = new MaxNumberLength(maxNumberLength);
        boolean actualResult = rule.checkIfMeetTheRule(inputNumber);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][] {
                {6, 123456, true},
                {6, 12345, false},
                {6, 1234567, false}
        };
    }

}