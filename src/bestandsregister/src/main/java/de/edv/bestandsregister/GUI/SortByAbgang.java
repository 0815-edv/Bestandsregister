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

    /**
     * Dient zur Sortierung der Übersichts JListe
     * von Aktiv und Inaktiven Einträgen.
     * @param schafA
     * @param schafB
     * @return 
     */
    public int compare(Schaf schafA, Schaf schafB) {
        // Initialisiere mit Inaktiv
        int a = 0;
        int b = 0;

        if (schafA.getDatumAbgang() != null) {
            if (schafA.getDatumAbgang().getTime() != 0) {
                // Setze Aktiv
                a = 1;
            }
        }

        if (schafB.getDatumAbgang() != null) {
            if (schafB.getDatumAbgang().getTime() != 0) {
                // Setze Aktiv
                b = 1;
            }
        }
        /**
         * Berechne Differenz
         * Bsp1. 
         * SchafA -> Aktiv (1)
         * SchafB -> Inaktiv (0)
         * 1-0 = 0 (status unverändert)
         * 
         * Bsp2.
         * SchafA -> Inaktiv (0)
         * SchafB -> Aktiv (1)
         * 0-1 = -1 (SchafB wird nach oben in der Liste verschoben)
         */
        return a - b;
    }
}
