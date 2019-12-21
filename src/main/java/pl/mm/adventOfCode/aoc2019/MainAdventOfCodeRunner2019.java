package pl.mm.adventOfCode.aoc2019;

import org.springframework.beans.factory.annotation.Autowired;
import pl.mm.adventOfCode.MainAdventOfCodeRunnerBase;
import pl.mm.adventOfCode.utilities.loadFile.LoadTxtFile;
import pl.mm.adventOfCode.utilities.converter.DoubleConverter;

public abstract class MainAdventOfCodeRunner2019 extends MainAdventOfCodeRunnerBase {

    @Autowired
    protected LoadTxtFile loadTxtFile;
    @Autowired
    protected DoubleConverter doubleConverter;

}
