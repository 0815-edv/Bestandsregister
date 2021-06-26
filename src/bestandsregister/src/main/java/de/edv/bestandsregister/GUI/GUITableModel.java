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
