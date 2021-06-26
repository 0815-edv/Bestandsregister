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
package de.edv.bestandsregister.SQL;

import de.edv.bestandsregister.Betriebsnummer;
import de.edv.bestandsregister.Entwurmen;
import de.edv.bestandsregister.Gedeckt;
import de.edv.bestandsregister.Impfungen;
import de.edv.bestandsregister.Klauenschneiden;
import de.edv.bestandsregister.Schaf;
import de.edv.bestandsregister.Schur;
import de.edv.bestandsregister.Transport;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Markus
 */
public class Get {

    /**
     * Get all Schafe from DB
     *
     * @return
     */
    public ArrayList<Schaf> schafe() {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Schaf> dbSchafe = new ArrayList<Schaf>();

        try {
            String sql = "SELECT * FROM Schaf ORDER BY DatumZugang DESC;";
            stm = Config.getSQLConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Schaf s = new Schaf(rs.getString("SchafID"));

                s.setKennung(rs.getString("Kennung"));
                s.setBemerkung(rs.getString("Bemerkung"));
                s.setGrundFürAbgang(rs.getString("GrundFürAbgang"));
                s.setMutterkennung(rs.getString("MutterKennung"));
                // Cast from String Possible ???
                s.setDatumAbgang(new java.sql.Date(rs.getLong("DatumAbgang")));
                s.setDatumZugang(new java.sql.Date(rs.getLong("DatumZugang")));
                if (rs.getBytes("Bild") != null) {
                    s.setBild(ImageIO.read(new ByteArrayInputStream(rs.getBytes("Bild"))));
                }

                dbSchafe.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbSchafe;
    }

    /**
     * Get Specific Betriebsnummern from DB
     *
     * @param SchafID
     * @return ArrayList with Betriebsnummern Objects
     */
    public ArrayList<Betriebsnummer> betriebsnummer(String SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Betriebsnummer> dbBetriebsnummer = new ArrayList<Betriebsnummer>();

        try {
            String sql = "SELECT * FROM Betriebsnummer WHERE SchafID = ?;";
            stm = Config.getSQLConnection().prepareStatement(sql);
            stm.setString(1, SchafID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Betriebsnummer s = new Betriebsnummer(rs.getString("SchafID"), rs.getString("BetriebsID"));

                s.setBetriebsnummer(rs.getString("Betriebsnummer"));
                s.setBemerkung(rs.getString("Bemerkung"));

                dbBetriebsnummer.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbBetriebsnummer;
    }

    /**
     * Get entwurmen objects from db
     *
     * @param SchafID
     * @return
     */
    public ArrayList<Entwurmen> entwurmen(String SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Entwurmen> dbEntwurmen = new ArrayList<Entwurmen>();

        try {
            String sql = "SELECT * FROM Entwurmen WHERE SchafID = ? ORDER BY Datum DESC;";
            stm = Config.getSQLConnection().prepareStatement(sql);
            stm.setString(1, SchafID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Entwurmen s = new Entwurmen(rs.getString("SchafID"), rs.getString("EntwurmenID"));

                s.setDatum(new java.sql.Date(rs.getLong("Datum")));

                dbEntwurmen.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbEntwurmen;
    }

    /**
     * Get Gedeckt Objects from DB
     *
     * @param SchafID
     * @return
     */
    public ArrayList<Gedeckt> gedeckt(String SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Gedeckt> dbGedeckt = new ArrayList<Gedeckt>();

        try {
            String sql = "SELECT * FROM Gedeckt WHERE SchafID = ? ORDER BY Datum DESC;";
            stm = Config.getSQLConnection().prepareStatement(sql);
            stm.setString(1, SchafID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Gedeckt s = new Gedeckt(rs.getString("SchafID"), rs.getString("GedecktID"));

                s.setVaterkennung(rs.getString("VaterKennung"));
                s.setDatum(new java.sql.Date(rs.getLong("Datum")));

                dbGedeckt.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbGedeckt;
    }

    /**
     * Get Impfungen Objects from DB
     *
     * @param SchafID
     * @return
     */
    public ArrayList<Impfungen> impfungen(String SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Impfungen> dbImpfung = new ArrayList<Impfungen>();

        try {
            String sql = "SELECT * FROM Impfungen WHERE SchafID = ? ORDER BY Datum DESC;";
            stm = Config.getSQLConnection().prepareStatement(sql);
            stm.setString(1, SchafID);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Impfungen s = new Impfungen(rs.getString("SchafID"), rs.getString("ImpfID"));

                s.setBemerkung(rs.getString("Bemerkung"));
                s.setImpfstoff(rs.getString("Impfstoff"));
                s.setDatum(new java.sql.Date(rs.getLong("Datum")));

                dbImpfung.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbImpfung;
    }

    /**
     * Get Klauenschneiden Objects from DB
     *
     * @param SchafID
     * @return
     */
    public ArrayList<Klauenschneiden> klauenschneiden(String SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Klauenschneiden> dbKlauenschneiden = new ArrayList<Klauenschneiden>();

        try {
            String sql = "SELECT * FROM Klauenschneiden WHERE SchafID = ? ORDER BY Datum DESC;";
            stm = Config.getSQLConnection().prepareStatement(sql);
            stm.setString(1, SchafID);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Klauenschneiden s = new Klauenschneiden(rs.getString("SchafID"), rs.getString("KlauenID"));

                s.setDatum(new java.sql.Date(rs.getLong("Datum")));

                dbKlauenschneiden.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbKlauenschneiden;
    }

    /**
     * Get Schur Object from DB
     *
     * @param SchafID
     * @return
     */
    public ArrayList<Schur> schur(String SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Schur> dbSchur = new ArrayList<Schur>();

        try {
            String sql = "SELECT * FROM Schur WHERE SchafID = ? ORDER BY Datum DESC;";
            stm = Config.getSQLConnection().prepareStatement(sql);
            stm.setString(1, SchafID);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Schur s = new Schur(rs.getString("SchafID"), rs.getString("SchurID"));

                s.setDatum(new java.sql.Date(rs.getLong("Datum")));

                dbSchur.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbSchur;
    }

    /**
     * Get Transport Objects From DB
     *
     * @param SchafID
     * @return
     */
    public ArrayList<Transport> transport(String SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Transport> dbTransport = new ArrayList<Transport>();

        try {
            String sql = "SELECT * FROM Transport WHERE SchafID = ? ORDER BY Datum DESC;";
            stm = Config.getSQLConnection().prepareStatement(sql);
            stm.setString(1, SchafID);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Transport s = new Transport(rs.getString("SchafID"), rs.getString("TransportID"));

                s.setTransportMittel(rs.getString("TransportMittel"));
                s.setGrund("Grund");
                s.setDatum(new java.sql.Date(rs.getLong("Datum")));

                dbTransport.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbTransport;
    }
}
