package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class TokenManager {

    public static String getToken() {

        try {

            Properties properties = new Properties();

            properties.load(new FileInputStream(
                    "src/test/resources/config.properties"));

            return properties.getProperty("token");

        } catch (Exception e) {

            throw new RuntimeException("Token not found");
        }
    }
}