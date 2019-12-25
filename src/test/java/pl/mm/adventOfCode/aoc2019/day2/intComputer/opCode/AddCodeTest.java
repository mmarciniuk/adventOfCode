package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCodeTest {

    @Test(dataProvider = "testDataProvider")
    public void testExecuteOpCodeImpl(int[] input, int[] expected, boolean isOpCodeExecutedExpected, Mode mode) {
        AddCode opCode = (AddCode) new AddCode().setMode(mode);
        int[] result = opCode.executeOpCode(input, 0);
        Assert.assertEquals(result, expected);
        Assert.assertEquals(opCode.isOpCodeExecuted(), isOpCodeExecutedExpected);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {new int[]{1, 5, 5, 3}, new int[]{1, 5, 5, 10}, true, Mode.POSITION_MODE},
                {new int[]{1, 2, 2, 3}, new int[]{1, 2, 2, 4}, true, Mode.POSITION_MODE},
                {new int[]{1, 2, -2, 3}, new int[]{1, 2, -2, -4}, true, Mode.POSITION_MODE},
                {new int[]{1, 2, 3, 3}, new int[]{1, 2, 3, 5}, true, Mode.IMMEDIATE_MODE}
        };
    }

}