package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.AddCode;

public class AddCodeTest {

    @Test(dataProvider = "testDataProvider")
    public void testExecuteOpCodeImpl(int[] input, int[] expected, boolean isExitExpected, boolean isOpCodeExecutedExpected) {
        AddCode opCode = new AddCode();
        int[] result = opCode.executeOpCode(input, 0);
        Assert.assertEquals(result, expected);
        //Assert.assertEquals(opCode.isExit(), isExitExpected);
        Assert.assertEquals(opCode.isOpCodeExecuted(), isOpCodeExecutedExpected);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {new int[]{1, 5, 5, 3}, new int[]{1, 5, 5, 10}, false, true},
                {new int[]{1, 2, 2, 3}, new int[]{1, 2, 2, 4}, false, true},
                {new int[]{1, 2, -2, 3}, new int[]{1, 2, -2, -4}, false, true},
        };
    }

}