package com.mivaschenko.fifthproblem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountingTest {
    private static final WordCounting proc = new WordCounting();
    private static final String bookPath =
            ".\\src\\test\\resources\\fifthproblem\\WarAndPeace.txt";
    private static final String directoryPath =
            ".\\src\\test\\resources\\fifthproblem\\WordFiles";
    private static final String countPath =
            ".\\src\\test\\resources\\fifthproblem\\Counts.txt";
    private static final String smallTextPath =
            ".\\src\\test\\resources\\fifthproblem\\SmallTextTest.txt";

    @BeforeAll
    static void init() {
        for(File file: Objects.requireNonNull(Paths.get(directoryPath).toFile().listFiles()))
            if (!file.isDirectory())
                file.delete();
        try {
            new PrintWriter(Paths.get(countPath).toString()).close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readAndCountTest() {
        try {
            proc.readAndCount(Paths.get(smallTextPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String expected = "bar = 1\nfoo = 3\nbaz = 1";
        assertEquals(expected, proc.mapToString());
    }

    @Test
    public void bigTextTest() {
        try {
            proc.readAndCount(Paths.get(bookPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            proc.printCount(Paths.get(countPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            proc.parallelFileCount(Paths.get(directoryPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
