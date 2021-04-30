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

/**
 *
 * @author Markus
 */
public class Update {

    Add insert = null;
    Del delete = null;

    public Update() {
        insert = new Add();
        delete = new Del();
    }

    public void schaf(Schaf schaf) {
        delete.schaf(schaf);
        insert.schaf(schaf);
    }

    public void betriebsnummer(Betriebsnummer bNummer) {
        delete.betriebsnummer(bNummer);
        insert.betriebsnummer(bNummer);
    }

    public void entwurmen(Entwurmen entwurmen) {
        delete.entwurmen(entwurmen);
        insert.entwurmen(entwurmen);
    }

    public void impfungen(Impfungen impfungen) {
        delete.impfungen(impfungen);
        insert.impfungen(impfungen);
    }

    public void klauenschneiden(Klauenschneiden klauen) {
        delete.klauenschneiden(klauen);
        insert.klauenschneiden(klauen);
    }

    public void schur(Schur schur) {
        delete.schur(schur);
        insert.schur(schur);
    }

    public void transport(Transport transport) {
        delete.transport(transport);
        insert.transport(transport);
    }

    public void gedeckt(Gedeckt gedeckt) {
        delete.gedeckt(gedeckt);
        insert.gedeckt(gedeckt);
    }
}
