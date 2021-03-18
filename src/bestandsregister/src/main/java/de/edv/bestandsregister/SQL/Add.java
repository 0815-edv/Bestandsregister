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
import de.edv.bestandsregister.Transport;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus
 */
public class Add {

    /**
     * Add Schaf to Database
     *
     * @param schaf
     */
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

    /**
     * Add Betriebsnummer to Database
     *
     * @param bNummer
     */
    public void betriebsnummer(Betriebsnummer bNummer) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Betriebsnummer(SchafID, Betriebsnummer, Bemerkung) VALUES (?, ?, ?)");

            stm.setInt(1, bNummer.getSchafID());
            stm.setString(2, bNummer.getBetriebsnummer());
            stm.setString(3, bNummer.getBemerkung());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Add Entwurmen to Database
     *
     * @param entwurmen
     */
    public void entwurmen(Entwurmen entwurmen) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Entwurmen(SchafID, Datum) VALUES (?, ?)");

            stm.setInt(1, entwurmen.getSchafID());
            stm.setDate(2, entwurmen.getDatum());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Add Gedeckt to Database;
     *
     * @param gedeckt
     */
    public void gedeckt(Gedeckt gedeckt) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Gedeckt(SchafID, VaterKennung, Datum) VALUES (?, ?, ?)");

            stm.setInt(1, gedeckt.getSchafID());
            stm.setString(2, gedeckt.getVaterkennung());
            stm.setDate(3, gedeckt.getDatum());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Add Impfungen to Database
     *
     * @param impfung
     */
    public void impfungen(Impfungen impfung) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Betriebsnummer(SchafID, Impfstoff, Bemerkung, Datum) VALUES (?, ?, ?, ?)");

            stm.setInt(1, impfung.getSchafID());
            stm.setString(2, impfung.getImpfstoff());
            stm.setString(3, impfung.getBemerkung());
            stm.setDate(4, impfung.getDatum());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Add Klauenschneiden to Database
     *
     * @param klauen
     */
    public void klauenschneiden(Klauenschneiden klauen) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Klauenschneiden(SchafID, Datum) VALUES (?, ?)");

            stm.setInt(1, klauen.getSchafID());
            stm.setDate(2, klauen.getDatum());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Add Schur to Database
     *
     * @param schur
     */
    public void schur(Schur schur) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Schur(SchafID, Datum) VALUES (?, ?)");

            stm.setInt(1, schur.getSchafID());
            stm.setDate(2, schur.getDatum());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Add Transport to Database
     *
     * @param transport
     */
    public void transport(Transport transport) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Transport(SchafID, TransportMittel, Grund, Datum) VALUES (?, ?, ?)");

            stm.setInt(1, transport.getSchafID());
            stm.setString(2, transport.getTransportMittel());
            stm.setString(3, transport.getGrund());
            stm.setDate(4, transport.getDatum());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }
}
