package org.tar.db.server.schema;


import net.sf.jsqlparser.schema.Table;

import java.io.Serial;
import java.io.Serializable;


public class TableManager implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    private String tableName;
    Table table;

    public TableManager(String tableName, Table table) {
        this.tableName = tableName;
        this.table = table;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
