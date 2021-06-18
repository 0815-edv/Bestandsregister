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
package de.edv.bestandsregister.GUI;

import de.edv.bestandsregister.Schaf;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Markus
 */
public class CellRenderer extends DefaultTableCellRenderer {

    /**
     * Custom Cell Renderer
     * Um die Einträge der Übersichts JListe optimal entsprechend
     * des Bestands entsprechend als aktiv oder inaktiv zu setzen.
     */
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean cellHasFocus, int rowCount, int columCount) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, cellHasFocus, rowCount, columCount);
        if (table.getModel().getValueAt(rowCount, columCount) != null) {
            Object schaf = table.getModel().getValueAt(rowCount, columCount);
            // Setze Anzeige Text
            setText(schaf.toString());
            
            if (schaf != null) {
                if (schaf instanceof Date) {
                    // Setzte Abgangs Kennzeichnung
                    setBackground(Color.RED);
                } else {
                    // Setze Bestands Kennzeichnung
                    setBackground(Color.GREEN);
                }
            } else {
                // Setze Bestandskennzeichnung wenn Datum NULL
                setBackground(Color.GREEN);
            }
            if (isSelected) {
                // Hebt das Aktiv ausgewählte Item hervor
                setBackground(getBackground().darker());
            }
        } else {
            // Fehler Objekt ist nicht vom Typ Schaf
            setText("Unknown Type?");
        }
        return c;
    }
}
