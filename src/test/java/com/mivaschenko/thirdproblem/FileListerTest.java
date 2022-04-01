package com.mivaschenko.thirdproblem;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class FileListerTest {
    @Test
    public void checkMainMethod() {
        try {
            FileLister.main(new String[]{"2", "1.txt"});
        }
        catch (Exception e) {
            fail("There is no such folder: 1.txt"+e);
        }
    }

    @Test
    public void checkListFilesMethod() {
        File testDir = new File(".\\src\\test\\java\\com\\mivaschenko\\thirdproblem\\testfolder");
        Path testWriteFile = Paths.get(".\\src\\test\\java\\com\\mivaschenko\\thirdproblem\\testfolder\\testFile.txt");
        try {
            assertTrue(FileLister.listFiles(testDir, testWriteFile, 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
