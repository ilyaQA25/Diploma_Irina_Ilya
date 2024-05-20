package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getLoginUrl() {
        return getBaseUrl()+properties.getProperty("loginUrl");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }
}
