package org.tar.db.cli;


import org.tar.db.server.command.CommandProcessor;

import java.util.Scanner;

public class DatabaseCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter(";");

        String dbName = (args.length == 0) ? "tarDb" : args[0];
        while (true) {
            System.out.print(dbName + "> ");
            String sql = scanner.next().replace("\n", " ").replace("\r", "").trim();

            if (sql.startsWith("exit")) {
                break;
            }else if (sql.startsWith("use")){
                dbName =  sql.substring(3,sql.length()-1).trim();
                System.out.println(dbName);
            }else {
                CommandProcessor.process(sql);
            }
        }


    }
}
