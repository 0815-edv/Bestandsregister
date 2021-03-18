/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Markus
 */
public class Config {

    private static Connection SQL;
    private static final String CONNECTION = "jdbc:sqlite:register.db";

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
                // Initialize new SQL DB
                init();
                SQL = DriverManager.getConnection(CONNECTION);
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

    /**
     * Initialize SQLite Database
     */
    protected static void init() {
        // SQL statement for creating a new table
        ArrayList<String> tables = new ArrayList<String>();
        tables.add("CREATE TABLE IF NOT EXISTS  Betriebsnummer  (\n"
                + "	 BetriebsID 	TEXT NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "	 SchafID 	TEXT NOT NULL,\n"
                + "	 Betriebsnummer TEXT NOT NULL,\n"
                + "	 Bemerkung 	TEXT\n"
                + ");");

        tables.add("CREATE TABLE IF NOT EXISTS  Gedeckt  (\n"
                + "	 GedecktID 	TEXT NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "	 SchafID 	TEXT NOT NULL,\n"
                + "	 VaterKennung 	TEXT NOT NULL,\n"
                + "	 Datum          TEXT NOT NULL\n"
                + ");");

        tables.add("CREATE TABLE IF NOT EXISTS  Klauenschneiden  (\n"
                + "	 KlauenID 	TEXT NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "	 SchafID 	TEXT NOT NULL,\n"
                + "	 Datum          TEXT NOT NULL\n"
                + ");");

        tables.add("CREATE TABLE IF NOT EXISTS  Impfungen  (\n"
                + "	 ImpfID 	TEXT NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "	 SchafID 	TEXT NOT NULL,\n"
                + "	 Impfstoff 	TEXT NOT NULL,\n"
                + "	 Bemerkung 	TEXT,\n"
                + "	 Datum          TEXT NOT NULL\n"
                + ");");

        tables.add("CREATE TABLE IF NOT EXISTS  Entwurmen  (\n"
                + "	 EntwurmenID 	TEXT NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "	 SchafID 	TEXT NOT NULL,\n"
                + "	 Datum          TEXT NOT NULL\n"
                + ");");

        tables.add("CREATE TABLE IF NOT EXISTS  Schur  (\n"
                + "	 SchurID 	TEXT NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "	 SchafID 	TEXT NOT NULL,\n"
                + "	 Datum          TEXT NOT NULL\n"
                + ");");

        tables.add("CREATE TABLE IF NOT EXISTS  Schaf  (\n"
                + "	 SchafID 	TEXT NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "	 DatumZugang 	TEXT,\n"
                + "	 DatumAbgang 	TEXT,\n"
                + "	 GrundFürAbgang TEXT,\n"
                + "	 Kennung 	TEXT,\n"
                + "	 Bemerkung 	TEXT,\n"
                + "	 MutterKennung 	TEXT\n"
                + ");");
        
        tables.add("CREATE TABLE IF NOT EXISTS Transport (\n"
                + "	TransportID     TEXT NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "	SchafID         TEXT NOT NULL,\n"
                + "	TransportMittel	TEXT NOT NULL,\n"
                + "	Grund           TEXT\n"
                + "	Datum           TEXT NOT NULL\n"
                + ")");

        try (Connection conn = DriverManager.getConnection(CONNECTION);
                Statement stmt = conn.createStatement()) {
            // create a new table
            for (String sql : tables) {
                stmt.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
