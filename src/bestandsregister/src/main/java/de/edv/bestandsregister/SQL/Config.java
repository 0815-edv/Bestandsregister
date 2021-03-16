/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Markus
 */
public class Config {

    private static Connection SQL;

    /**
     * Return SQLite JDBC Connection
     *
     * @return
     */
    protected static Connection getSQLConnection() {
        return SQL;
    }

    /**
     * Open SQLite Database
     */
    protected static void open() {
        Connection conn = null;
        if (SQL == null) {
            try {
                SQL = DriverManager.getConnection("jdbc:sqlite:register.db");
                conn = SQL;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                if (SQL != null) {
                    try {
                        SQL.close();
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
    }

    /**
     * Close SQLite Database
     */
    protected static void close() {
        if (SQL != null) {
            try {
                SQL.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
