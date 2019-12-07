package pl.mm.adventOfCode.aoc2019.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.mm.adventOfCode.BaseTest;
import pl.mm.adventOfCode.Main;

@SpringBootTest(classes = {Main.class})
public class ProgramAlarm1202ImplTest extends BaseTest {

    @Autowired
    private ProgramAlarm1202Impl programAlarm1202;

    @Test(dataProvider = "dataProvider")
    public void testExecute(String input, String expectedResult) {
        String result = this.programAlarm1202.execute(input);
        Assert.assertEquals(result, expectedResult);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"1,10,20,40", "1,10,20,30"},
                {"1,9,10,3,2,3,11,0,99,30,40,50", "3500,9,10,70,2,3,11,0,99,30,40,50"},
                {"1,0,0,0,99", "2,0,0,0,99"},
                {"2,3,0,3,99", "2,3,0,6,99"},
                {"2,4,4,5,99,0", "2,4,4,5,99,9801"},
                {"1,1,1,4,99,5,6,0,99", "30,1,1,4,2,5,6,0,99"}
        };
    }

}