package dream.properties;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


/**
 * @author ArvikV
 * @version 1.0
 * @since 09.12.2021
 */
public class Config {
     static Properties properties = new Properties();
    private final static Config INSTANCE = new Config();

    public static Config getConfig() {
        return INSTANCE;
    }

    public Config() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("path.properties")) {
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
