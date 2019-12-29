package pl.mm.adventOfCode.aoc2019.day6;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniversalOrbitMapComputerImplTest {

    @Test(dataProvider = "testDataProvider")
    public void testCalculateNumberOfOrbits(List<String> inputMap, int expectedResult) {
        UniversalOrbitMapComputerImpl orbitMapComputer = new UniversalOrbitMapComputerImpl();
        int actualResult = orbitMapComputer.calculateNumberOfOrbits(inputMap);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][] {
                {new ArrayList<>(Arrays.asList("COM)B","B)C","C)D","D)E","E)F","B)G","G)H","D)I","E)J","J)K","K)L")), 42}
        };
    }

}