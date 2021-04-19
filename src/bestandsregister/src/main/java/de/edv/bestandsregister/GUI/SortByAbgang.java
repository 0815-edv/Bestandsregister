/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister.GUI;

import de.edv.bestandsregister.Schaf;
import java.util.Comparator;

/**
 *
 * @author Markus
 */
public class SortByAbgang implements Comparator<Schaf> {
// Used for sorting in ascending order of ID  

    public int compare(Schaf schafA, Schaf schafB) {
        int a = 0;
        int b = 0;

        if (schafA.getDatumAbgang() != null) {
            if (schafA.getDatumAbgang().getTime() != 0) {
                a = 1;
            }
        }

        if (schafB.getDatumAbgang() != null) {
            if (schafB.getDatumAbgang().getTime() != 0) {
                b = 1;
            }
        }

        return a - b;
    }
}
