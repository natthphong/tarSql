package org.tar.db.server.schema;


import net.sf.jsqlparser.schema.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class TableManager implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;


    private volatile long lastBlock;
    private String tableName;

    private transient List<ColumManager> columManagers;

    public TableManager(String tableName,List<ColumManager> columManagers) {
        this.tableName = tableName;
        this.lastBlock = 0;
        this.columManagers = columManagers;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumManager> getColumManagers() {
        return columManagers;
    }

    public void setColumManagers(List<ColumManager> columManagers) {
        this.columManagers = columManagers;
    }




    public synchronized  void setLastBlock(int lastBlock){
        this.lastBlock = lastBlock;
    }
    public   long getLastBlock(){
        return this.lastBlock;
    }
}
