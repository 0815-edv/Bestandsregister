/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister.GUI;

import de.edv.bestandsregister.Schaf;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Markus
 */
public class CellRenderer extends DefaultListCellRenderer {

    @Override
    /**
     * Custom Cell Renderer
     * Um die Einträge der Übersichts JListe optimal entsprechend
     * des Bestands entsprechend als aktiv oder inaktiv zu setzen.
     */
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Schaf) {
            Schaf schaf = (Schaf) value;
            // Setze Anzeige Text
            setText(schaf.toString());
            
            if (schaf.getDatumAbgang() != null) {
                if (schaf.getDatumAbgang().getTime() != 0) {
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
