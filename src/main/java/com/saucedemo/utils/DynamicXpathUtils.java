package com.saucedemo.utils;

/**
 * Constructs a dynamic xpath at run time.
 *
 * @author Balaji
 */

public class DynamicXpathUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private DynamicXpathUtils() {}

    /**
     * Receives a wildcard string, replace the wildcard with the value and return to the caller
     * @author Balaji
     * @param xpath Xpath with wildcard string (%s)
     * @param value value to be replaced in place of wildcard
     * @return dynamic xpath string
     *
     */

    public static String getXpath(String xpath, String... value) {
        return String.format(xpath, value);
    }
}
