package com.project.urlshortener.utils;

import java.util.HashMap;

public class CommonUtils {
    public static HashMap<Integer, Character> referenceTable = new HashMap<>();
    static {
        // Populate the map with values 0-9, a-z, A-Z
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < characters.length(); i++) {
            referenceTable.put(i, characters.charAt(i));
        }
    }
}
