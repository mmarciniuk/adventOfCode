package pl.mm.adventOfCode.aoc2019.day2.opCode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipliesCodeTest {

    @Test(dataProvider = "testDataProvider")
    public void testExecuteOpCodeImpl(int[] input, int[] expected, boolean isExitExpected, boolean isOpCodeExecutedExpected) {
        MultipliesCode opCode = new MultipliesCode();
        int[] result = opCode.executeOpCode(input, 0);
        Assert.assertEquals(result, expected);
        Assert.assertEquals(opCode.isExit(), isExitExpected);
        Assert.assertEquals(opCode.isOpCodeExecuted(), isOpCodeExecutedExpected);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {new int[]{2, 9, 9, 3}, new int[]{2, 9, 9, 81}, false, true},
                {new int[]{2, 2, 2, 3}, new int[]{2, 2, 2, 4}, false, true},
                {new int[]{2, 2, -2, 3}, new int[]{2, 2, -2, 4}, false, true},
        };
    }

}