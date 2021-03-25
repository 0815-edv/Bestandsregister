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
import java.sql.Date;

/**
 *
 * @author lorenz
 */
public class Impfungen {

    private String schafID;
    private String impfID;
    private String impfstoff;
    private String bemerkung;
    private Date datum;

    public Impfungen(String schafID) {
        this.schafID = schafID;
        this.impfID = IdentifierService.generateGUID();
    }

    public Impfungen(String schafID, String impfID) {
        this.schafID = schafID;
        this.impfID = impfID;
    }

    public String getSchafID() {
        return schafID;
    }

    public String getImpfID() {
        return impfID;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public String getImpfstoff() {
        return impfstoff;
    }

    public Date getDatum() {
        return datum;
    }

    public void setImpfstoff(String impfstoff) {
        this.impfstoff = impfstoff;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String toString() {
        return impfstoff + " " + datum.toString();
    }
}
