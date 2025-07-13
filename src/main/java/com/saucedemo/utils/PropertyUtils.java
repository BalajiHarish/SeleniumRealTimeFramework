package com.saucedemo.utils;

import com.saucedemo.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * Read the property file and store it in a HashMap for faster processing.
 * Users can prefer to use json instead of property file based on their requirement.
 *
 * @author Balaji
 */

public final class PropertyUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private PropertyUtils() {}

    private static final Properties properties = new Properties();

    static {
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            properties.load(file);
        } catch (IOException e) {
            System.out.println("Error here");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * @author Balaji
     * @param key To be fetched from property file
     */

    public static String getValue(String key) throws IllegalArgumentException {
        if(Objects.isNull(key) || Objects.isNull(properties.getProperty(key))) {
            throw new IllegalArgumentException("Property named " + key + " is not found in config.properties file");
        }
        return properties.getProperty(key).trim();
    }
}
