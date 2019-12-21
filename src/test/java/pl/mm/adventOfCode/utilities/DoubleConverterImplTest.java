package pl.mm.adventOfCode.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.mm.adventOfCode.BaseTest;
import pl.mm.adventOfCode.Main;
import pl.mm.adventOfCode.utilities.converter.DoubleConverterImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = {Main.class})
public class DoubleConverterImplTest extends BaseTest {

    @Autowired
    private DoubleConverterImpl doubleConverter;

    @Test(dataProvider = "testData")
    public void testConvertValues(List<String> input, int numberOfLinesWhichShouldBeLoaded) {
        List<Double> doubleList = this.doubleConverter.convert(input);
        Assert.assertEquals(doubleList.size(), numberOfLinesWhichShouldBeLoaded);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList("a", "b", "c", "a", "d")), 0},
                {new ArrayList<>(Arrays.asList("1", "2", "3", "a", "5")), 4}
        };
    }
}