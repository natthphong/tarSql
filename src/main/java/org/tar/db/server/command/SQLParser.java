package org.tar.db.server.command;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;


public class SQLParser {
    public static Statement parse(String sql) throws Exception {
        return CCJSqlParserUtil.parse(sql);
    }
}