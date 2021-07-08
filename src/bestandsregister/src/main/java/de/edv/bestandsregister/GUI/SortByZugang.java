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
import java.util.Comparator;

/**
 *
 * @author Markus
 */
public class SortByZugang implements Comparator<Schaf> {
// Used for sorting in ascending order of ID  

    /**
     * Dient zur Sortierung der Übersichts JListe.
     *
     * @param schafA
     * @param schafB
     * @return
     */
    public int compare(Schaf schafA, Schaf schafB) {
        // Initialisiere mit Inaktiv
        int a = 0;
        int b = 0;

        if (schafA.getDatumZugang() != null) {
            if (schafA.getDatumZugang().getTime() != 0) {
                // Setze Aktiv
                a = 1;
            }
        }

        if (schafB.getDatumZugang() != null) {
            if (schafB.getDatumZugang().getTime() != 0) {
                // Setze Aktiv
                b = 1;
            }
        }
        /**
         * Berechne Differenz Bsp1. SchafA -> Aktiv (1) SchafB -> Inaktiv (0)
         * 1-0 = 0 (status unverändert)
         *
         * Bsp2. SchafA -> Inaktiv (0) SchafB -> Aktiv (1) 0-1 = -1 (SchafB wird
         * nach oben in der Liste verschoben)
         */
        return a - b;
    }
}
