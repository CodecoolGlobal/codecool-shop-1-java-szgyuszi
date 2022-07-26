package com.codecool.shop.config;

import com.google.gson.internal.bind.util.ISO8601Utils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {

    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    String defaultConfigPath = rootPath + "src/main/resources/applicationConfig.properties";

    private static final Properties appProps = new Properties();
    String appConfigPath = rootPath + "applicationConfig.properties";

    public Properties connect() throws IOException {

        appProps.load(new FileInputStream(appConfigPath));
        return appProps;
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