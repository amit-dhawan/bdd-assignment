package com.amit.assignment.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    private static Properties prop;
    public static FileInputStream fis;

    public static String getConfigValueFor(String key) throws IOException {
        prop = new Properties();
        fis = new FileInputStream("src\\test\\resources\\config.properties");
        prop.load(fis);

        return prop.getProperty(key);
    }

}
