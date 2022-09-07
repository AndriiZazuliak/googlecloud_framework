package org.as.ta.services;

import java.util.ResourceBundle;

public class TestDataReader {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("src/main/resources/" + System.getProperty("environment"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}