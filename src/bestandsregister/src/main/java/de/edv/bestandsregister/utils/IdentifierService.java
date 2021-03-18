/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister.utils;

import java.util.UUID;

/**
 *
 * @author Markus
 */
public class IdentifierService {

    /**
     * Generate GUID used as PKey in Database
     *
     * @return
     */
    public static String generateGUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
