/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister.SQL;

import de.edv.bestandsregister.Betriebsnummer;
import de.edv.bestandsregister.Entwurmen;
import de.edv.bestandsregister.Gedeckt;
import de.edv.bestandsregister.Impfungen;
import de.edv.bestandsregister.Klauenschneiden;
import de.edv.bestandsregister.Schaf;
import de.edv.bestandsregister.Schur;
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

    /**
     * Get Specific Betriebsnummern from DB
     *
     * @param SchafID
     * @return ArrayList with Betriebsnummern Objects
     */
    public ArrayList<Betriebsnummer> betriebsnummer(int SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Betriebsnummer> dbBetriebsnummer = new ArrayList<Betriebsnummer>();

        try {
            String sql = "SELECT * FROM Betriebsnummer WHERE SchafID = ?;";
            stm.setInt(1, SchafID);
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Betriebsnummer s = new Betriebsnummer(rs.getInt("SchafID"), rs.getInt("BetriebsID"));

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
     * @param SchafID
     * @return 
     */
    public ArrayList<Entwurmen> entwurmen(int SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Entwurmen> dbEntwurmen = new ArrayList<Entwurmen>();

        try {
            String sql = "SELECT * FROM Entwurmen WHERE SchafID = ?;";
            stm.setInt(1, SchafID);
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Entwurmen s = new Entwurmen(rs.getInt("SchafID"), rs.getInt("EntwurmenID"));

                s.setDatum(rs.getDate("Datum"));

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
     * @param SchafID
     * @return 
     */
    public ArrayList<Gedeckt> gedeckt(int SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Gedeckt> dbGedeckt = new ArrayList<Gedeckt>();

        try {
            String sql = "SELECT * FROM Gedeckt WHERE SchafID = ?;";
            stm.setInt(1, SchafID);
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Gedeckt s = new Gedeckt(rs.getInt("SchafID"), rs.getInt("GedecktID"));

                s.setVaterkennung(rs.getString("VaterKennung"));
                s.setDatum(rs.getDate("Datum"));

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
     * @param SchafID
     * @return 
     */
    public ArrayList<Impfungen> impfungen(int SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Impfungen> dbImpfung = new ArrayList<Impfungen>();

        try {
            String sql = "SELECT * FROM Impfungen WHERE SchafID = ?;";
            stm.setInt(1, SchafID);
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Impfungen s = new Impfungen(rs.getInt("SchafID"), rs.getInt("ImpfID"));

                s.setBemerkung(rs.getString("Bemerkung"));
                s.setImpfstoff(rs.getString("Impfstoff"));
                s.setDatum(rs.getDate("Datum"));

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
     * @param SchafID
     * @return 
     */
    
    public ArrayList<Klauenschneiden> klauenschneiden(int SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Klauenschneiden> dbKlauenschneiden = new ArrayList<Klauenschneiden>();

        try {
            String sql = "SELECT * FROM Klauenschneiden WHERE SchafID = ?;";
            stm.setInt(1, SchafID);
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Klauenschneiden s = new Klauenschneiden(rs.getInt("SchafID"), rs.getInt("KlauenID"));

                s.setDatum(rs.getDate("Datum"));

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
     * @param SchafID
     * @return 
     */
    public ArrayList<Schur> schur(int SchafID) {
        Config.open();
        PreparedStatement stm = null;
        ArrayList<Schur> dbSchur = new ArrayList<Schur>();

        try {
            String sql = "SELECT * FROM Schur WHERE SchafID = ?;";
            stm.setInt(1, SchafID);
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Schur s = new Schur(rs.getInt("SchafID"), rs.getInt("SchurID"));

                s.setDatum(rs.getDate("Datum"));

                dbSchur.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Get.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
        return dbSchur;
    }
}
