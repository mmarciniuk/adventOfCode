package pl.mm.adventOfCode.aoc2019.day4.rule;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RuleTestCombineRulesForAoC2019 {

    @Test(dataProvider = "testDataProvider")
    public void testCombineRules(int inputNumber, boolean expectedResult) {

    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][] {
                {111111, true},
                {223450, false},
                {123789, false}
        };
    }

}
