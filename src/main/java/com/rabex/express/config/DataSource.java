package com.rabex.express.config;

import java.util.ResourceBundle;

public class DataSource {
    private final String url;
    private final String username;
    private final String password;

    private static final String URL_KEY = "datasource.url";
    private static final String PASSWORD_KEY = "datasource.password";
    private static final String USERNAME_KEY = "datasource.username";


    public DataSource() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        this.url = resourceBundle.getString(URL_KEY);
        this.username = resourceBundle.getString(USERNAME_KEY);
        this.password = resourceBundle.getString(PASSWORD_KEY);
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
