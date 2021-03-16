/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister.SQL;

import de.edv.bestandsregister.Schaf;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus
 */
public class Add {
     public void schaf(Schaf schaf) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Schaf(DatumZugang, DatumAbgang, GrundFürAbgang, Kennung, Bemerkung, MutterKennung) VALUES (?, ?, ?, ?, ?, ?)");

            stm.setDate(1, schaf.getDatumZugang());
            stm.setDate(2, schaf.getDatumAbgang());
            stm.setString(3, schaf.getGrundFürAbgang());
            stm.setString(4, schaf.getKennung());
            stm.setString(5, schaf.getBemerkung());
            stm.setString(6, schaf.getMutterkennung());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }
}
