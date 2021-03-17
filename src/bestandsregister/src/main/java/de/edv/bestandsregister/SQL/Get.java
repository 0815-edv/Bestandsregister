/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister.SQL;

import de.edv.bestandsregister.Schaf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus
 */
public class Get {

    public ArrayList<Schaf> schafe() {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Schaf> dbSchafe = new ArrayList<Schaf>();

        try {
            String sql = "SELECT * FROM Schaf;";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Schaf s = new Schaf(rs.getInt("SchafID"));
                
                s.setKennung(rs.getString("Kennung"));
                s.setBemerkung(rs.getString("Bemerkung"));
                s.setGrundFürAbgang(rs.getString("GrundFürAbgang"));
                s.setMutterkennung(rs.getString("MutterKennung"));
                s.setDatumAbgang(rs.getDate("DatumAbgang"));
                s.setDatumZugang(rs.getDate("DatumZugang"));
                
                dbSchafe.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbSchafe;
    }
}
