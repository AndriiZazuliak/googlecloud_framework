package org.as.ta.services;

import java.util.ResourceBundle;

public class TestDataReader {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("dev");
//    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
