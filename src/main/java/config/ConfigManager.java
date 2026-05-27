package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties;

    static {

        try {

            properties = new Properties();

            FileInputStream file =
                    new FileInputStream(
                            "src/test/resources/config.properties");

            properties.load(file);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to load config.properties file");
        }
    }

    public static String getBaseUrl() {

        return properties.getProperty("base.url");
    }

    public static String getToken() {

        return properties.getProperty("token");
    }

    public static String getEnvironment() {

        return properties.getProperty("environment");
    }
}