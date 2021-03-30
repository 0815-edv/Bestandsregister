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
