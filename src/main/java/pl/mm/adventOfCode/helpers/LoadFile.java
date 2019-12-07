package pl.mm.adventOfCode.helpers;

import java.util.List;

public interface LoadFile {

    /**
     * Load file and return list of lines.
     *
     * @return List of loaded lines from file.
     */
    List<String> loadFile(String absolutePath);

}
