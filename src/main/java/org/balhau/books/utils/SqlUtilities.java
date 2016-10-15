package org.balhau.books.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Bunch of utility classes needed for SQL operations
 * Created by vitorfernandes on 10/9/16.
 */
public class SqlUtilities {
    private static final String SQLITE_JDBC="org.sqlite.JDBC";
    private static final String SQLITE_CON_PREFIX="jdbc:sqlite:";

    public static Connection getSQLiteConnection(String path) throws SQLException, ClassNotFoundException{
        Class.forName(SQLITE_JDBC);
        return DriverManager.getConnection(SQLITE_CON_PREFIX+path);
    }
}
