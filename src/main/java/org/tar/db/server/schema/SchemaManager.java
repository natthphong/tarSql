package org.tar.db.server.schema;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchemaManager {
    private Map<String, TableSchema> schemas;

    public SchemaManager() {
        this.schemas = new HashMap<>();
    }

    public void createTable(String tableName, List<ColumnSchema> columns, String primaryKey) {
        if (schemas.containsKey(tableName)) {
            throw new IllegalArgumentException("Table already exists");
        }

        TableSchema schema = new TableSchema(tableName, columns, primaryKey);
        schemas.put(tableName, schema);
    }

    public TableSchema getTableSchema(String tableName) {
        return schemas.get(tableName);
    }

    public void addIndex(String tableName, String columnName, TableSchema.IndexType indexType) {
        TableSchema schema = schemas.get(tableName);
        if (schema != null) {
            schema.addIndex(columnName, indexType);
        } else {
            throw new IllegalArgumentException("Table does not exist");
        }
    }
}
