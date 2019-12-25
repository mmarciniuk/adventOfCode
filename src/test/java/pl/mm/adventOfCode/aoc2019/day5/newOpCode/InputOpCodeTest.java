package pl.mm.adventOfCode.aoc2019.day5.newOpCode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.OpCode;

public class InputOpCodeTest {

    @Test(dataProvider = "testDataProvider")
    public void testExecuteOpCode(int[] tablesWithCodes, int inputValue, int[] expected,
                                          boolean expectedIsOpCodeExecuted) {
        OpCode opCode = new InputOpCode(inputValue);
        int[] result = opCode.executeOpCode(tablesWithCodes, 0);
        Assert.assertEquals(result, expected);
        Assert.assertEquals(opCode.isOpCodeExecuted(), expectedIsOpCodeExecuted);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {new int[]{3, 0}, 55, new int[]{55, 0}, true}
        };
    }

}