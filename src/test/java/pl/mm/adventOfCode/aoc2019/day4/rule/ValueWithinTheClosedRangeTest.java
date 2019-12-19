package pl.mm.adventOfCode.aoc2019.day4.rule;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValueWithinTheClosedRangeTest {

    @Test(dataProvider = "testDataProvider")
    public void testCheckIfMeetTheRule(int minValue, int maxValue, int inputNumber, boolean expectedResult) {
        Rule rule = new ValueWithinTheClosedRange(minValue, maxValue);
        boolean actualResult = rule.checkIfMeetTheRule(inputNumber);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][] {
                {193651, 649729, 193651, true},
                {193651, 649729, 649729, true},
                {193651, 649729, 193652, true},
                {193651, 649729, 649728, true},
                {193651, 649729, 193650, false},
                {193651, 649729, 649730, false}
        };
    }

}