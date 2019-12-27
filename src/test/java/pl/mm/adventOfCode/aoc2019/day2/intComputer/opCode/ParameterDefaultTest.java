package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterDefaultTest {

    @Test(dataProvider = "testDataProvider")
    public void testGetValue(Parameter parameter, int expectedValue) {
        int actualValue = parameter.getValue();
        Assert.assertEquals(actualValue, expectedValue);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {new ParameterDefault(Mode.POSITION_MODE, new int[]{1, 2, 3, 4}, 0), 2},
                {new ParameterDefault(Mode.POSITION_MODE, new int[]{2, 2, 3, 4}, 0), 3},
                {new ParameterDefault(Mode.IMMEDIATE_MODE, new int[]{1, 2, 3, 4}, 0), 1}
        };
    }

}