/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import de.edv.bestandsregister.Betriebsnummer;
import de.edv.bestandsregister.Entwurmen;
import de.edv.bestandsregister.Gedeckt;
import de.edv.bestandsregister.Impfungen;
import de.edv.bestandsregister.Klauenschneiden;
import de.edv.bestandsregister.SQL.Add;
import de.edv.bestandsregister.Schaf;
import de.edv.bestandsregister.Schur;
import de.edv.bestandsregister.Transport;
import java.io.File;
import java.sql.Date;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 *
 * @author Markus
 */
@TestInstance(Lifecycle.PER_CLASS)
public class TestDBData {

    Schaf s = new Schaf();
    File f = new File("register.db");

    @Test()
    public void insertSchaf() {
        try {
            Add insert = new Add();
            s.setBemerkung("bemerkung");
            s.setGrundFürAbgang("grundFürAbgang");
            s.setKennung("kennung");
            s.setMutterkennung("mutterkennung");
            s.setDatumAbgang(new Date(System.currentTimeMillis()));
            s.setDatumZugang(new Date(System.currentTimeMillis() + 100000));
            s.setBild(RandomImage.read());
            insert.schaf(s);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void insertBetriebsnummer() {
        try {
            Add insert = new Add();
            Betriebsnummer b = new Betriebsnummer(s.getSchafID());
            b.setBemerkung("bemerkung");
            b.setBetriebsnummer("Betriebsnummer");
            insert.betriebsnummer(b);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void insertEntwurmen() {
        try {
            Add insert = new Add();
            Entwurmen e = new Entwurmen(s.getSchafID());
            e.setDatum(new Date(System.currentTimeMillis()));
            insert.entwurmen(e);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void insertGedeckt() {
        try {
            Add insert = new Add();
            Gedeckt g = new Gedeckt(s.getSchafID());
            g.setVaterkennung("VaterKennung");
            g.setDatum(new Date(System.currentTimeMillis()));
            insert.gedeckt(g);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void insertImpfungen() {
        try {
            Add insert = new Add();
            Impfungen i = new Impfungen(s.getSchafID());
            i.setBemerkung("Bemerkung");
            i.setImpfstoff("impfstoff");
            i.setDatum(new Date(System.currentTimeMillis()));
            insert.impfungen(i);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void insertKlauen() {
        try {
            Add insert = new Add();
            Klauenschneiden k = new Klauenschneiden(s.getSchafID());
            k.setDatum(new Date(System.currentTimeMillis()));
            insert.klauenschneiden(k);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void insertSchur() {
        try {
            Add insert = new Add();
            Schur sch = new Schur(s.getSchafID());
            sch.setDatum(new Date(System.currentTimeMillis()));
            insert.schur(sch);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void insertTransport() {
        try {
            Add insert = new Add();
            Transport t = new Transport(s.getSchafID());
            t.setGrund("grund");
            t.setTransportMittel("transportMittel");
            t.setDatum(new Date(System.currentTimeMillis()));
            insert.transport(t);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    @AfterAll
    public void testDelete() {
        assertTrue(f.delete());
    }
}
