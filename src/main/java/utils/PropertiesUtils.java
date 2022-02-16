package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesUtils {

    public static Properties getProperty(String path) {
        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
