package org.tar.db.server.utils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {


    public static void initFile(String path){
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
    public void test() throws IOException {

        try (FileOutputStream fos = new FileOutputStream("dist/schemas.dat", true);
             FileChannel fc = fos.getChannel();
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            fc.position(10);
            oos.writeObject(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Object> colum = new ArrayList<>();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(colum);
        }
        File dbTable = new File("test.tbl");
        RandomAccessFile randomAccessFile =  new RandomAccessFile(dbTable, "rws");
        randomAccessFile.seek(100);

//        randomAccessFile.getChannel().truncate();
//        randomAccessFile.write(colum);
    }
}
