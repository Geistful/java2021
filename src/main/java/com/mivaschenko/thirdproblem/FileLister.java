package com.mivaschenko.thirdproblem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Objects;

public class FileLister {
    public static boolean listFiles(File dir, Path writeFile, int level) throws IOException {
        if(dir==null||dir.listFiles()==null){
            return true;
        }
        for (File entry : Objects.requireNonNull(dir.listFiles())) {
            if (entry.isFile()) {
                Files.write(writeFile, Collections.singleton(" ".repeat(level) + "| File: " + entry),
                            Files.exists(writeFile) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
            } else {
                Files.write(writeFile, Collections.singleton(" ".repeat(level) + "|-> Folder: " + entry),
                        Files.exists(writeFile) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
                listFiles(entry, writeFile, level+4);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        File dir = new File(args[0]);
        Path writeFile = Paths.get(args[1]);
        if (!writeFile.toFile().exists() || !writeFile.toFile().isDirectory()) {
            try {
                throw new IOException("There is no such folder: " + writeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(writeFile, Collections.singleton("Contents of \"" + dir + "\""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            listFiles(dir, writeFile, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
