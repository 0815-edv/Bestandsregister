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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
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
            List<String> tables = Arrays.asList("Schaf", "Betriebsnummer", "Entwurmen", "Gedeckt", "Impfungen", "Klauenschneiden", "Schur", "Transport");

            for (String tabel : tables) {
                stm = Config.getSQLConnection().prepareStatement("DELETE FROM "+tabel+" WHERE SchafID = ?");

                stm.setString(1, schaf.getSchafID());

                stm.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }

    /**
     * Delete Betriebsnummer from DB
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
