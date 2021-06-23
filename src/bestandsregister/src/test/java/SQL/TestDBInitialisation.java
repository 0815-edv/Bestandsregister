/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.io.File;
import org.junit.jupiter.api.Test;
import de.edv.bestandsregister.SQL.*;
import de.edv.bestandsregister.Schaf;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Markus
 */
public class TestDBInitialisation {

    /**
     * Test Creation of the SQLite Database File
     */
    @Test
    public void TestDB() {
        // Test IF Fiele Exists
        File f = new File("register.db");
        if (!f.exists() && !f.isDirectory()) {
            Add insert = new Add();
            
            Schaf s = new Schaf();
            s.setBemerkung("bemerkung");
            s.setGrundFürAbgang("grundFürAbgang");
            s.setKennung("kennung");
            s.setMutterkennung("mutterkennung");
            s.setDatumAbgang(new Date(System.currentTimeMillis()));
            s.setDatumZugang(new Date(System.currentTimeMillis() + 100000));
            s.setBild(RandomImage.read());
            
            insert.schaf(s);
        }

        ArrayList<String> tables = new ArrayList<String>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:register.db");
                Statement stmt = conn.createStatement()) {
            String s = "SELECT name FROM sqlite_master WHERE type='table';";

            ResultSet rs = stmt.executeQuery(s);

            while (rs.next()) {
                tables.add(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            assertFalse(true);
        }

        assertTrue(tables.size() == 8 && f.exists());
        f.delete();
    }
}
