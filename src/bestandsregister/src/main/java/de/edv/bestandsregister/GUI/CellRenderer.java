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
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Schaf) {
            Schaf schaf = (Schaf) value;
            setText(schaf.getKennung());
            if (schaf.getDatumAbgang() != null) {
                setBackground(Color.RED);
            }
            if (isSelected) {
                setBackground(getBackground().darker());
            }
        } else {
            setText("Unknown Type?");
        }
        return c;
    }
}
