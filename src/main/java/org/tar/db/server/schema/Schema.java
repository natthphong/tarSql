package org.tar.db.server.schema;


import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Schema implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;
    private String schemaName;
    private Map<String, TableManager> tables;

    public Schema(String schemaName) {
        this.schemaName = schemaName;
        this.tables = new HashMap<>();
    }

    public String getSchemaName() {
        return schemaName;
    }

    public Map<String, TableManager> getTables() {
        return tables;
    }

    public void addTable(TableManager table) {
        tables.put(table.getTableName(), table);
    }

}
