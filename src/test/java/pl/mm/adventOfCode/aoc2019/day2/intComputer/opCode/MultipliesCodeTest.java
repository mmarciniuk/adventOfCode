package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipliesCodeTest {

    @Test(dataProvider = "testDataProvider")
    public void testExecuteOpCodeImpl(int[] input, int[] expected, boolean isOpCodeExecutedExpected, Mode mode) {
        MultipliesCode opCode = new MultipliesCode();
        int[] result = opCode.executeOpCode(input, 0);
        Assert.assertEquals(result, expected);
        Assert.assertEquals(opCode.isOpCodeExecuted(), isOpCodeExecutedExpected);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {new int[]{2, 9, 9, 3}, new int[]{2, 9, 9, 81}, true, Mode.POSITION_MODE},
                {new int[]{2, 2, 2, 3}, new int[]{2, 2, 2, 4}, true, Mode.POSITION_MODE},
                {new int[]{2, 2, -2, 3}, new int[]{2, 2, -2, 4}, true, Mode.POSITION_MODE},
                {new int[]{2, 2, 3, 3}, new int[]{2, 2, 3, 6}, true, Mode.IMMEDIATE_MODE},
        };
    }

}