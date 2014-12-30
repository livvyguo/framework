package com.lvy.framework.chapter1;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by livvy on 14-5-24.
 */
public class Test4 {

    public static void main(String[] args) {
        FileSearch fileSearch = new FileSearch("D:\\", "pom.xml");
        Thread t = new Thread(fileSearch);
        t.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
    public static class FileSearch implements Runnable {

        private String initPath;
        private String fileName;

        public FileSearch(String initPath, String fileName) {
            this.initPath = initPath;
            this.fileName = fileName;
        }

        @Override
        public void run() {
            File file = new File(initPath);
            if (file.isDirectory()) {
                try {
                    directoryProcess(file);
                } catch (InterruptedException e) {
                    System.out.printf("%s : The search has been interrupted",Thread.currentThread().getName());
                }
            }
        }

        private void directoryProcess(File file) throws InterruptedException {
            File[] listFiles = file.listFiles();
            if (Objects.nonNull(listFiles)) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        directoryProcess(listFiles[i]);
                    } else {
                        fileProcess(listFiles[i]);
                    }
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        private void fileProcess(File file) throws InterruptedException{
            if (file.getName().equals(fileName)) {
                System.out.printf("%s : %s %n",Thread.currentThread().getName(),file.getAbsolutePath());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }
    }
}
