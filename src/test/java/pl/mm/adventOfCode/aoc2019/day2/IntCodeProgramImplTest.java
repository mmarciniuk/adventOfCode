package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.mm.adventOfCode.BaseTest;
import pl.mm.adventOfCode.Main;

@SpringBootTest(classes = {Main.class})
public class IntCodeProgramImplTest extends BaseTest {

    @Autowired
    private IntCodeProgramImpl programAlarm1202;

    @Test(dataProvider = "dataProvider")
    public void testExecute(int[] input, int[] expectedResult) {
        int[] result = this.programAlarm1202.execute(input);
        Assert.assertEquals(result, expectedResult);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {new int[]{1,10,20,40}, new int[]{1,10,20,30}},
                {new int[]{1,9,10,3,2,3,11,0,99,30,40,50}, new int[]{3500,9,10,70,2,3,11,0,99,30,40,50}},
                {new int[]{1,0,0,0,99}, new int[]{2,0,0,0,99}},
                {new int[]{2,3,0,3,99}, new int[]{2,3,0,6,99}},
                {new int[]{2,4,4,5,99,0}, new int[]{2,4,4,5,99,9801}},
                {new int[]{1,1,1,4,99,5,6,0,99}, new int[]{30,1,1,4,2,5,6,0,99}}
        };
    }

}