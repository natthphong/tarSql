package org.tar.db.server.schema;

import java.io.*;

public class FileSystemBlockManager {
    private final RandomAccessFile randomAccessFile;
    private final File dbTable;

    public FileSystemBlockManager(File dbTable) throws FileNotFoundException {
        this.randomAccessFile =  new RandomAccessFile(dbTable, "rws");
        this.dbTable = dbTable;
    }

    public  void writeBlock(byte[] block , int seek) throws IOException {
        randomAccessFile.seek(seek);
        randomAccessFile.write(block);
    }

    public static Object deserializeByteArrayToList(byte[] byteArray) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
        try (ObjectInputStream ois = new ObjectInputStream(bis)) {
            return  ois.readObject();
        }
    }

    public void fullScan(){

    }


    public File getDbTable() {
        return dbTable;
    }
}
