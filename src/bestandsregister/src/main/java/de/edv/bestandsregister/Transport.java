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
 * @author Markus
 */
public class Transport {

    private String transportID;
    private String schafID;
    private String transportMittel;
    private String grund;
    private Date datum;

    public Transport(String schafID) {
        this.schafID = schafID;
        this.transportID = IdentifierService.generateGUID();
    }

    public Transport(String schafID, String transportID) {
        this.schafID = schafID;
        this.transportID = transportID;
    }

    public String getTransportID() {
        return transportID;
    }

    public String getSchafID() {
        return schafID;
    }

    public String getTransportMittel() {
        return transportMittel;
    }

    public String getGrund() {
        return grund;
    }

    public Date getDatum() {
        return datum;
    }

    public void setTransportMittel(String transportMittel) {
        this.transportMittel = transportMittel;
    }

    public void setGrund(String grund) {
        this.grund = grund;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String toString() {
        return grund + " " + datum.toString();
    }
}
