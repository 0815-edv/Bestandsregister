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
package de.edv.bestandsregister;

import de.edv.bestandsregister.utils.IdentifierService;
import java.awt.Image;
import java.sql.Date;

/**
 *
 * @author lorenz
 */
public class Schaf {

    private String schafID;
    private Date datumZugang;
    private Date datumAbgang;
    private String grundFürAbgang;
    private String kennung;
    private String bemerkung;
    private String mutterkennung;
    private Image bild;

    public Schaf() {
        this.schafID = IdentifierService.generateGUID();
    }

    public Schaf(String schafID) {
        this.schafID = schafID;
    }

    public String getSchafID() {
        return schafID;
    }

    public Date getDatumZugang() {
        return datumZugang;
    }

    public void setDatumZugang(Date datumZugang) {
        this.datumZugang = datumZugang;
    }

    public Date getDatumAbgang() {
        return datumAbgang;
    }

    public void setDatumAbgang(Date datumAbgang) {
        this.datumAbgang = datumAbgang;
    }

    public String getGrundFürAbgang() {
        return grundFürAbgang;
    }

    public void setGrundFürAbgang(String grundFürAbgang) {
        this.grundFürAbgang = grundFürAbgang;
    }

    public String getKennung() {
        return kennung;
    }

    public void setKennung(String kennung) {
        this.kennung = kennung;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getMutterkennung() {
        return mutterkennung;
    }

    public void setMutterkennung(String mutterkennung) {
        this.mutterkennung = mutterkennung;
    }

    public Image getBild() {
        return this.bild;
    }

    public void setBild(Image bild) {
        this.bild = bild;
    }

    public String toString() {
        return kennung;
    }
}
