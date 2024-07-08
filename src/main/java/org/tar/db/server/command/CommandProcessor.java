package org.tar.db.server.command;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.schema.CreateSchema;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tar.db.server.schema.ColumManager;
import org.tar.db.server.schema.SchemaManager;
import org.tar.db.server.schema.TableManager;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessor {
    private static final Logger log = LoggerFactory.getLogger(CommandProcessor.class);

    private static  SchemaManager schemaManager = SchemaManager.loadFromFile();


    public static void process(String dbName,String command) {
        try {
            Statement stmt = SQLParser.parse(command);
            if (stmt instanceof Select) {
                System.out.println("SELECT");
            } else if (stmt instanceof Insert) {
                System.out.println("INSERT");
            } else if (stmt instanceof Update) {
                System.out.println("Update");
            } else if (stmt instanceof Delete) {
                System.out.println("Delete");
            } else if (stmt instanceof CreateTable) {
                handleCreateTable(dbName,(CreateTable) stmt);
            }else if (stmt instanceof CreateSchema){
                handleCreateSchema((CreateSchema) stmt);
            } else {
                System.out.println("Unsupported command.");
            }
        } catch (Exception e) {
            System.out.println("Failed to parse command: " + e.getMessage());
        }
    }

    private static void handleCreateSchema(CreateSchema createSchema) {
        String schemaName = createSchema.getSchemaName();
        schemaManager.createSchema(schemaName);
        System.out.println("Schema " + schemaName + " created successfully.");
    }

    private static void handleCreateTable(String dbName,CreateTable createTable) {
        Table table = createTable.getTable();
        String tableName = table.getName();
        List<ColumnDefinition> columnDefinitions = createTable.getColumnDefinitions();
        List<ColumManager> columManagers = new ArrayList<>();
        for (ColumnDefinition columnDefinition : columnDefinitions) {
            ColumManager temp = new ColumManager(columnDefinition.getColDataType().getDataType(),columnDefinition.getColumnName(),columnDefinition.getColumnSpecs());
            columManagers.add(temp);
        }
        schemaManager.createTable(dbName, new TableManager(table.getSchemaName(),columManagers));
        System.out.println("Table " + tableName + " created successfully in schema " + dbName + ".");
    }

}