package com.codecool.shop.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    private static final Properties appProps = new Properties();
    String appConfigPath = rootPath + "applicationConfig.properties";

    public void connect() throws IOException {
        appProps.load(new FileInputStream(appConfigPath));
    }

    public static String getDbName() {
        return appProps.getProperty("database");
    }

    public static String url() {
        return appProps.getProperty("url");
    }

    public static String user() {
        return appProps.getProperty("user");
    }

    public static String password() {
        return appProps.getProperty("password");
    }
}