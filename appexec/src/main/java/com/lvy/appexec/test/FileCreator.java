package com.lvy.appexec.test;

import javafx.print.Printer;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.nio.file.FileSystem;

/**
 * Created by livvy on 14-8-24.
 */
public class FileCreator implements Runnable{

    private File rootDir;

    private static final String lineSeparator = System.getProperty("line.separator","\n");

    public FileCreator(File rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    public void run() {
        String fileName = RandomStringUtils.random(5,"qwertyuiopasdfghjklzxcvbnm") + "-"+System.currentTimeMillis() + ".tdd";
        File file = new File(rootDir, fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fw);
            printWriter.println("id=" + RandomStringUtils.randomNumeric(100));
            printWriter.println("name="+ RandomStringUtils.random(5,"ASDFGHJKLQWERTYUIOPMNBVCXZ"));
            printWriter.close();
            System.out.println("create file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
