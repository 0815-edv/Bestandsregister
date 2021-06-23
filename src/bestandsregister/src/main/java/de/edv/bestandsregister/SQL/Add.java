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
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Schaf(SchafID, DatumZugang, DatumAbgang, GrundFürAbgang, Kennung, Bemerkung, MutterKennung, Bild) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            stm.setString(1, schaf.getSchafID());
            stm.setDate(2, schaf.getDatumZugang());
            stm.setDate(3, schaf.getDatumAbgang());
            stm.setString(4, schaf.getGrundFürAbgang());
            stm.setString(5, schaf.getKennung());
            stm.setString(6, schaf.getBemerkung());
            stm.setString(7, schaf.getMutterkennung());
            
            Image img = schaf.getBild();
            BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            bi.getGraphics().drawImage(img, 0, 0 , null);
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos );
            byte[] imageInByte = baos.toByteArray();
            
            stm.setBytes(1, imageInByte);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
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
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Betriebsnummer(BetriebsID, SchafID, Betriebsnummer, Bemerkung) VALUES (?, ?, ?, ?)");

            stm.setString(1, bNummer.getBetriebsID());
            stm.setString(2, bNummer.getSchafID());
            stm.setString(3, bNummer.getBetriebsnummer());
            stm.setString(4, bNummer.getBemerkung());

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
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Entwurmen(EntwurmenID, SchafID, Datum) VALUES (?, ?, ?)");

            stm.setString(1, entwurmen.getEntwurmenID());
            stm.setString(2, entwurmen.getSchafID());
            stm.setDate(3, entwurmen.getDatum());

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
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Gedeckt(GedecktID, SchafID, VaterKennung, Datum) VALUES (?, ?, ?, ?)");

            stm.setString(1, gedeckt.getGedecktID());
            stm.setString(2, gedeckt.getSchafID());
            stm.setString(3, gedeckt.getVaterkennung());
            stm.setDate(4, gedeckt.getDatum());

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
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Impfungen(ImpfID, SchafID, Impfstoff, Bemerkung, Datum) VALUES (?, ?, ?, ?, ?)");

            stm.setString(1, impfung.getImpfID());
            stm.setString(2, impfung.getSchafID());
            stm.setString(3, impfung.getImpfstoff());
            stm.setString(4, impfung.getBemerkung());
            stm.setDate(5, impfung.getDatum());

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
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Klauenschneiden(KlauenID, SchafID, Datum) VALUES (?, ?, ?)");

            stm.setString(1, klauen.getKlauenID());
            stm.setString(2, klauen.getSchafID());
            stm.setDate(3, klauen.getDatum());

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
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Schur(SchurID, SchafID, Datum) VALUES (?, ?, ?)");

            stm.setString(1, schur.getSchurID());
            stm.setString(2, schur.getSchafID());
            stm.setDate(3, schur.getDatum());

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
            stm = Config.getSQLConnection().prepareStatement("INSERT INTO Transport(TransportID, SchafID, TransportMittel, Grund, Datum) VALUES (?, ?, ?, ?, ?)");

            stm.setString(1, transport.getTransportID());
            stm.setString(2, transport.getSchafID());
            stm.setString(3, transport.getTransportMittel());
            stm.setString(4, transport.getGrund());
            stm.setDate(5, transport.getDatum());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Config.close();
        }
    }
}
