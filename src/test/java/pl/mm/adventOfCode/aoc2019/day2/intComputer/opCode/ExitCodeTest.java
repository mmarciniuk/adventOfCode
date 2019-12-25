package pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.mm.adventOfCode.aoc2019.day2.intComputer.opCode.ExitCode;

public class ExitCodeTest {

    @Test(dataProvider = "testDataProvider")
    public void testExecuteOpCodeImpl(int[] input, int[] expected, boolean isExitExpected, boolean isOpCodeExecutedExpected) {
        ExitCode opCode = new ExitCode();
        int[] result = opCode.executeOpCode(input, 0);
        Assert.assertEquals(result, expected);
        //Assert.assertEquals(opCode.isExit(), isExitExpected);
        Assert.assertEquals(opCode.isOpCodeExecuted(), isOpCodeExecutedExpected);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {new int[]{99, 2, 3, 4}, new int[]{99, 2, 3, 4}, true, true}
        };
    }

}