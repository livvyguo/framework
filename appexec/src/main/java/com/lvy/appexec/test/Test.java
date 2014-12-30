package com.lvy.appexec.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by livvy on 14-8-24.
 */
public class Test {

    public static final String PATH = Test.class.getClassLoader().getResource("").getPath();

    public static final File ROOT_FOLDER;

    public static final String ROOT_FOLDER_NAME = "rootfd";

    static {
        ROOT_FOLDER = new File(PATH + File.separator + ROOT_FOLDER_NAME);
        if(!ROOT_FOLDER.exists()) {
            boolean mkdir = ROOT_FOLDER.mkdir();
            System.out.println(mkdir);
        } else {
            if (!ROOT_FOLDER.isDirectory()) {
                boolean delete = ROOT_FOLDER.delete();
                if (delete) {
                    ROOT_FOLDER.mkdir();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

//        System.out.println(PATH);
//        System.out.println(ROOT_FOLDER.getAbsolutePath());
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        service.scheduleAtFixedRate(new FileMonitor(), 1, 1, TimeUnit.SECONDS);
//        File file = new File(ROOT_FOLDER, "tt.txt");
//        boolean newFile = file.createNewFile();
//        System.out.println(newFile);
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        service.scheduleAtFixedRate(new FileCreator(ROOT_FOLDER), 1, 10, TimeUnit.SECONDS);
//        File f = new File(ROOT_FOLDER,"bljgv-1408889721548.tdd");
//        try(BufferedReader reader = new BufferedReader(new FileReader(f))) {
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//        boolean delete = f.delete();
//        System.out.println("the file is delete" + delete);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Printer(),1,2,TimeUnit.SECONDS);
    }


    public static class Printer implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "-" +i);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
