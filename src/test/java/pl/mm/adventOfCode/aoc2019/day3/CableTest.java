package pl.mm.adventOfCode.aoc2019.day3;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CableTest {

    private Cable cable;

    @BeforeMethod
    public void initForTest() {
        cable = new Cable();
    }

    @Test(dataProvider = "dataProvider")
    public void testAddLayoutToCable(String path, int expectedCableLength) {
        String[] pathArray = path.split(",");
        cable.addLayout(pathArray);
        Assert.assertEquals(cable.getLength(), expectedCableLength);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"R8,U5,L5,D3", 21},
                {"U7,R6,D4,L4", 21},
                {"R75,D30,R83,U83,L12,D49,R71,U7,L72", 482},
                {"U62,R66,U55,R34,D71,R55,D58,R83", 484},
                {"R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", 573},
                {"U98,R91,D20,R16,D67,R40,U7,R15,U6,R7", 367}
        };
    }


}