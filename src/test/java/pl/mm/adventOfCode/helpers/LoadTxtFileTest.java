package pl.mm.adventOfCode.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.mm.adventOfCode.BaseTest;
import pl.mm.adventOfCode.Main;

import java.io.IOException;
import java.util.List;

@SpringBootTest(classes = {Main.class})
public class LoadTxtFileTest extends BaseTest {

    @Autowired
    private LoadTxtFile loadTxtFile;

    @Test
    public void testLoadFile() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("testData/testLoadFile.txt");
        List<String> listOfLinesLoadedFromFile = this.loadTxtFile.loadFile(classPathResource.getFile().getAbsolutePath());
        Assert.assertTrue(listOfLinesLoadedFromFile.size() > 0);
    }


}