package pl.mm.adventOfCode.aoc2019.day5.newOpCode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OutputOpCodeTest {

    @Test(dataProvider = "testDataProvider")
    public void testExecuteOpCode(int[] inputTableWithCodes, int expectedOutput, boolean expectedIsExecutedOpCode) {
        OutputOpCode opCode = new OutputOpCode();
        opCode.executeOpCode(inputTableWithCodes, 0);
        Assert.assertEquals(opCode.isOpCodeExecuted(), expectedIsExecutedOpCode);
        Assert.assertEquals(opCode.getOutput(), expectedOutput);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {new int[]{4, 0}, 4, true},
                {new int[]{4, 55}, 55, true},
                {new int[]{4, 3, 1, 2, 3}, 2, true}
        };
    }

}