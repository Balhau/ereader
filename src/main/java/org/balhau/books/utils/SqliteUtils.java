package org.balhau.books.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Bunch of utility classes needed for sqlite operations
 */
public class SqliteUtils {
    private static final String SQLITE_JDBC="org.sqlite.JDBC";
    private static final String SQLITE_CON_PREFIX="jdbc:sqlite:";

    /**
     * Utility method to encapsulate {@link Connection} creation for SQLite databses
     * @param path
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getSQLiteConnection(String path) throws SQLException, ClassNotFoundException{
        Class.forName(SQLITE_JDBC);
        return DriverManager.getConnection(SQLITE_CON_PREFIX+path);
    }
}
