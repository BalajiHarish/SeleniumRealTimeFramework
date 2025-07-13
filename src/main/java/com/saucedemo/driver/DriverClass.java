package com.saucedemo.driver;

import com.google.common.util.concurrent.Uninterruptibles;
import com.saucedemo.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 *
 * Driver class is responsible for invoking and closing the browsers.
 *
 * <p>
 * It is also responsible for
 * setting the driver variable to DriverManager which handles the thread safety for the
 * webdriver instance.
 * </p>
 *
 * @author Balaji
 * @see DriverManager
 * @see com.saucedemo.tests
 */

public final class DriverClass {

    /**
     * Private constructor to avoid external instantiation
     */
    private DriverClass() {}

    /**
     * Gets the browser value and initialise the browser based on that
     *
     * @author Balaji
     * @param browser Value will be passed from {@link com.saucedemo.tests}. Values can be chrome, firefox or edge
     *
     */

    public static void initDriver(String browser) {

        if(Objects.isNull(DriverManager.getDriver())) {  //calling driver instance only if it is null, so that we can avoid calling driver multiple times
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Browser Invocation Failed. Please check browser Capabilities", e);
            }
            DriverManager.getDriver().get(PropertyUtils.getValue("URL"));
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    /**
     * Terminates the browser instance.
     * Sets the thread local to default value, i.e null.
     * @author Balaji
     */

    public static void quitDriver() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS); //alternate to Thread.sleep where we don't need to handle exceptions
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }
}