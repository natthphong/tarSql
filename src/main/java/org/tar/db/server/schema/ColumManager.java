package org.tar.db.server.schema;

import java.io.Serializable;
import java.util.List;

public class ColumManager implements Serializable {
    private String type;

    private String columName;
    private List<String> columnSpecs;

    public ColumManager(String type, String columName, List<String> columnSpecs) {
        this.type = type;
        this.columName = columName;
        this.columnSpecs = columnSpecs;
    }


    public List<String> getColumnSpecs() {
        return columnSpecs;
    }

    public void setColumnSpecs(List<String> columnSpecs) {
        this.columnSpecs = columnSpecs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColumName() {
        return columName;
    }

    public void setColumName(String columName) {
        this.columName = columName;
    }

    @Override
    public String toString() {
        return "ColumManager{" +
                "type='" + type + '\'' +
                ", columName='" + columName + '\'' +
                '}';
    }
}
