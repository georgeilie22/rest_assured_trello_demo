package utils;

import java.util.Properties;

public class CredentialsDTO {

    private static final String PATH = "src/main/resources/credentials.properties";
    private static final Properties properties = PropertiesUtils.getProperty(PATH);

    public static String getKey() {
        return properties.getProperty("key");
    }

    public static String getToken() {
        return properties.getProperty("token");
    }
}
