package com.saucedemo.driver;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager class helps to achieve thread safety for the {@link WebDriver} instance.
 *
 * @author Balaji
 * @see DriverClass
 */

public final class DriverManager {

    /**
     * Private constructor to avoid external instantiation
     */

    private DriverManager() {}

    private final static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    /**
     * Returns the thread safe {@link WebDriver} instance fetched from ThreadLocal variable.
     *
     * @author Balaji
     * @return {@link WebDriver} instance.
     */

    public static WebDriver getDriver() {
        return dr.get();
    }

    /**
     * Set the WebDriver instance to thread local variable
     *
     * @author Balaji
     * @param driverRef {@link WebDriver} instance that needs to saved from Thread safety issues.<p>
     */

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    /**
     * Calling remove method on Thread local variable ensures to set the default value to Thread local variable.
     * It is much safer than assigning null value to ThreadLocal variable.
     * @author Balaji
     */

    public static void unloadDriver() {
        dr.remove();
    }
}
