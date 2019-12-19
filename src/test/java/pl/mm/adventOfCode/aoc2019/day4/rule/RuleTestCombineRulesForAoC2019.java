package pl.mm.adventOfCode.aoc2019.day4.rule;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RuleTestCombineRulesForAoC2019 {

    private List<Rule> ruleList = Arrays.asList(
            new MaxNumberLength(6),
            new ValueWithinTheClosedRange(111111, 649729),
            new TwoAdjacentDigitsAreTheSame(),
            new FromLeftToRightIncrease()
    );

    @Test(dataProvider = "testDataProvider")
    public void testCombineRules(int inputNumber, boolean expectedResult) {
        boolean actualResult = true;
        for (Rule rule : this.ruleList) {
            actualResult = actualResult && rule.checkIfMeetTheRule(inputNumber);
        }
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {12345, true},
                {111111, true},
                {223450, false},
                {123789, false}
        };
    }

}
