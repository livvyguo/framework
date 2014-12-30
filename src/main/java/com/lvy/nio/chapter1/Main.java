package com.lvy.nio.chapter1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.nio.file.attribute.FileTime.fromMillis;

/**
 * Created by livvy on 14-5-10.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:/","xxx.txt").normalize();

        FileSystem fileSystem = FileSystems.getDefault();
        Path path1 = fileSystem.getPath("D:/", "zzz.txt");
        System.out.println(path1);
        System.out.println(path);

        System.out.println(System.getProperty("user.home"));

        System.out.println(path.getRoot());
        System.out.println(path.getNameCount());
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(path.getName(i));
        }

        System.out.println(path.toAbsolutePath());

        Path path2 = fileSystem.getPath("F:/", "/book/new1");

        for(Path name : path2) {
            System.out.println(name);
        }


        FileSystem fs = FileSystems.getDefault();

        Set<String> views = fs.supportedFileAttributeViews();

        System.out.println("--------------------");
        for(String view : views) {
            System.out.println(view);
        }
        System.out.println("-------------");
        for(FileStore store : fs.getFileStores()) {
            boolean b = store.supportsFileAttributeView(BasicFileAttributeView.class);
            System.out.println(store.name() + " is supported " + b);
        }

        Path path3 = Paths.get("F:\\", "book\\new1", "Clojure in Action.pdf");
        BasicFileAttributes attributes = Files.readAttributes(path3, BasicFileAttributes.class);

        System.out.println("file size : " + attributes.size());
        System.out.println("file creation time : " + attributes.creationTime());
        System.out.println("file last access time : " + attributes.lastAccessTime());
        System.out.println("file last modified time :" + attributes.lastModifiedTime());


        System.out.println("Is directory : " + attributes.isDirectory());
        System.out.println("Is regular file : " + attributes.isRegularFile());
        System.out.println("Is symbolic link : " +  attributes.isSymbolicLink());
        System.out.println("Is other : " + attributes.isOther());

        System.out.println("----------------------");

        Path path4 = Paths.get("D://", "xxxxxxx.txt");
//        Path f = Files.createFile(path4);
        long time = System.currentTimeMillis();
        FileTime fileTime = fromMillis(time);

//        Files.getFileAttributeView(path4,BasicFileAttributeView.class).setTimes(fileTime,fileTime,fileTime);

        Files.setLastModifiedTime(path4,fileTime);

        BasicFileAttributes attributes1 = Files.readAttributes(path4, BasicFileAttributes.class);
        System.out.println(attributes1.lastModifiedTime());

        UserPrincipal owner = path4.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("livvy");

        System.out.println(owner);

        FileOwnerAttributeView foav = Files.getFileAttributeView(path4, FileOwnerAttributeView.class);

        String name = foav.getOwner().getName();
        System.out.println(name);

        Path path5 = Paths.get("D://", "xnmx.txt");
//        Path file = Files.createFile(path5);

//        boolean exists = Files.exists(file);
        //        System.out.println(exists);
        System.out.println("---------------------------");
        try(DirectoryStream<Path> ds  = Files.newDirectoryStream(Paths.get("D://"),"*.{txt}")) {
            for (Path f : ds) {
                System.out.println(f.getFileName());
            }
        }

        System.out.println("----------------------------");
        Iterable<Path> rootDirectories = fileSystem.getRootDirectories();
        for(Path p : rootDirectories) {
            System.out.println(p);
        }


        System.out.println("----------------------------");

        File[] files = File.listRoots();
        for(File root  : files) {
            System.out.println(root);
        }
        System.out.println("---------------------------");

        DirectoryStream.Filter<Path> pathFilter = (DirectoryStream.Filter<Path>) entry ->
                fromMillis(System.currentTimeMillis()).to(TimeUnit.DAYS) ==
                        ((FileTime) Files.getAttribute(entry, "basic:lastModifiedTime",
                                LinkOption.NOFOLLOW_LINKS)).to(TimeUnit.DAYS);

        boolean accept = pathFilter.accept(path5);

        System.out.println(accept);


        System.out.println("---------------------------");

/*        Path rf_wiki_path = Paths.get("D:/", "wiki.txt");

        String rf_wiki = "Rafael \"Rafa\" Nadal Parera (born 3 June 1986) is a Spanish professional";
        try {
            byte[] rf_wiki_byte = rf_wiki.getBytes("UTF-8");
            Files.write(rf_wiki_path, rf_wiki_byte);
        } catch (IOException e) {
            System.err.println(e);
        }*/

        Path rf_wiki_path = Paths.get("D:/", "wiki.txt");

        Charset charset = Charset.forName("UTF-8");
        List<String> lines = new ArrayList<>();
        lines.add("\n");
        lines.add("Rome Masters - 5 titles in 6 years");
        lines.add("Monte Carlo Masters - 7 consecutive titles (2005-2011)");
        lines.add("Australian Open - Winner 2009");
        lines.add("Roland Garros - Winner 2005-2008, 2010, 2011");
        lines.add("Wimbledon - Winner 2008, 2010");
        lines.add("US Open - Winner 2010");
        try {
            Files.write(rf_wiki_path, lines, charset, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e);
        }

        byte[] bytes = Files.readAllBytes(rf_wiki_path);
        String s = new String(bytes, "UTF-8");
        System.out.println(s);

        System.out.println("--------------------");

        Charset charset1 = Charset.forName("UTF-8");
        List<String> strings = Files.readAllLines(rf_wiki_path, charset1);
        for(String line : strings) {
            System.out.println(line);
        }


    }


    public boolean accept(Path path) throws IOException {
        long currentTime = fromMillis(System.currentTimeMillis()).to(TimeUnit.DAYS);
        long modifiedTime = ((FileTime) Files.getAttribute(path, "basic:lastModifiedTime", LinkOption.NOFOLLOW_LINKS)).to(TimeUnit.DAYS);
        return currentTime == modifiedTime;
    }
}
