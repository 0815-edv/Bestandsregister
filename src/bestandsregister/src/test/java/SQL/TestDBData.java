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
