package com.hellofresh.challenge.helpers;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    public static Properties prop = new Properties();

    static {
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("data.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
