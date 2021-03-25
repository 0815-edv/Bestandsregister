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
public class Del {

    /*
    Delete Schaf from DB
     */
    public void schaf(Schaf schaf) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("DELETE FROM Schaf WHERE SchafID = ?");

            stm.setString(1, schaf.getSchafID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Delete Betriebsnummer from DB
     * @param bNummer 
     */
    public void betriebsnummer(Betriebsnummer bNummer) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("DELETE FROM Betriebsnummer WHERE BetriebsID = ?");

            stm.setString(1, bNummer.getBetriebsID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Delete Entwurmen from DB
     * @param entwurmen 
     */
    public void entwurmen(Entwurmen entwurmen) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("DELETE FROM Entwurmen WHERE EntwurmenID = ?");

            stm.setString(1, entwurmen.getEntwurmenID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Delete Gedeckt fron DB
     * @param gedeckt 
     */
    public void gedeckt(Gedeckt gedeckt) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("DELETE FROM Gedeckt WHERE GedecktID = ?");

            stm.setString(1, gedeckt.getGedecktID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Delete Impfungen from DB
     * @param impfung 
     */
    public void impfungen(Impfungen impfung) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("DELETE FROM Impfungen WHERE ImpfID = ?");

            stm.setString(1, impfung.getImpfID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Delete Klauenschneiden from DB
     * @param klauen 
     */
    public void klauenschneiden(Klauenschneiden klauen) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("DELETE FROM Klauenschneiden WHERE KlauenID = ?");

            stm.setString(1, klauen.getKlauenID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Delete Schur from DB
     * @param schur 
     */
    public void schur(Schur schur) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("DELETE FROM Schur WHERE SchurID = ?");

            stm.setString(1, schur.getSchurID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Delete Transport from DB
     * @param transport 
     */
    public void transport(Transport transport) {
        Config.open();
        PreparedStatement stm = null;

        try {
            stm = Config.getSQLConnection().prepareStatement("DELETE FROM Transport WHERE TransportID = ?");

            stm.setString(1, transport.getTransportID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }
}
