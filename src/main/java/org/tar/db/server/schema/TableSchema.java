package org.tar.db.server.schema;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TableSchema {
    private String tableName;
    private List<ColumnSchema> columns;
    private String primaryKey;
    private Map<String, IndexType> indexes;

    public TableSchema(String tableName, List<ColumnSchema> columns, String primaryKey) {
        this.tableName = tableName;
        this.columns = columns;
        this.primaryKey = primaryKey;
        this.indexes = new HashMap<>();
    }

    public String getTableName() {
        return tableName;
    }

    public List<ColumnSchema> getColumns() {
        return columns;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void addIndex(String columnName, IndexType indexType) {
        indexes.put(columnName, indexType);
    }

    public Map<String, IndexType> getIndexes() {
        return indexes;
    }

    public enum IndexType {
        BTREE,
        HASH
    }
}

class ColumnSchema {
    private String columnName;
    private String columnType;
    private boolean isPrimaryKey;

    public ColumnSchema(String columnName, String columnType, boolean isPrimaryKey) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }
}
