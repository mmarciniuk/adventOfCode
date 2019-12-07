package pl.mm.adventOfCode.helpers;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoadTxtFile implements LoadFile {

    @Override
    public List<String> loadFile(String absolutePath) {
        List<String> loadedLines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
            String textLine = bufferedReader.readLine();
            while (textLine != null) {
                loadedLines.add(textLine);
                textLine = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception ignored) {
        }
        return loadedLines;
    }
}
