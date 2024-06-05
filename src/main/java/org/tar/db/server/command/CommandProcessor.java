package org.tar.db.server.command;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.create.table.CreateTable;
public class CommandProcessor {
    public static void process(String command) {
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

                System.out.println("CreateTable");
            } else {
                System.out.println("Unsupported command.");
            }
        } catch (Exception e) {
            System.out.println("Failed to parse command: " + e.getMessage());
        }
    }
}