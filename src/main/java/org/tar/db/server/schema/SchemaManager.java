package org.tar.db.server.schema;


import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.HashMap;
import java.util.Map;

public class SchemaManager implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Map<String, Schema> schemas;

    public SchemaManager() {
        this.schemas = new HashMap<>();
    }

    public void createSchema(String schemaName) {
        if (schemas.containsKey(schemaName)) {
            throw new IllegalArgumentException("Schema already exists");
        }
        schemas.put(schemaName, new Schema(schemaName));
        saveToFile();
    }

    public Schema getSchema(String schemaName) {
        return schemas.get(schemaName);
    }

    public void createTable(String schemaName, TableManager table) {
        Schema schema = schemas.get(schemaName);
        if (schema == null) {
            throw new IllegalArgumentException("Schema does not exist");
        }
        schema.addTable(table);
        saveToFile();
    }

    public void saveToFile() {
        File directory = new File("dist");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dist/schemas.dat"))) {
            oos.writeObject(this);
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    public static SchemaManager loadFromFile() {
        File directory = new File("dist");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dist/schemas.dat"))) {
            return (SchemaManager) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new SchemaManager();
        }
    }
}
