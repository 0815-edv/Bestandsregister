/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister.GUI;

import de.edv.bestandsregister.Schaf;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Markus
 */
public class GUITableModel extends AbstractTableModel {

    private List<Schaf> schafe;
    
    public GUITableModel(List<Schaf> schafe){
        this.schafe = schafe;
    }
    
    @Override
    public int getRowCount() {
        return schafe.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int index){
        String [] name = {"ID", "Zugang", "Abgang"};
        return name[index];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columIndex) {
        if(columIndex < 3){
            switch(columIndex){
                case 0:
                    return schafe.get(rowIndex).getKennung();
                case 1:
                    return schafe.get(rowIndex).getDatumZugang();
                case 2:
                    return schafe.get(rowIndex).getDatumAbgang();
            }
        }
        return "Fehler";
    }
    
}
