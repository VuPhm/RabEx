package com.rabex.express.config;

import java.util.ResourceBundle;

public class ApplicationPropertiesLoader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

    public static int getInt(String key){
        return Integer.parseInt(resourceBundle.getString(key));
    }

    public static String get(String key){
        return resourceBundle.getString(key);
    }
}
