/*
 * MIT License
 *
 *  Copyright (c) 2021 Markus, Lorenz, flwerner
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */
package SQL;

import java.io.File;
import org.junit.jupiter.api.Test;
import de.edv.bestandsregister.SQL.*;
import de.edv.bestandsregister.Schaf;
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
