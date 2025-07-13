package com.saucedemo.utils;

import com.saucedemo.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Utility to take base64 screenshot.
 *
 * @author Balaji
 * @see com.saucedemo.reports.ReportLogger
 */

public final class ScreenshotUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private ScreenshotUtils() {};

    /**
     * Captures screenshot of the current page, constructs a base64 string from the image and return to the caller.
     * There is no temporary screenshot image generated here. If user needs separate screenshot image, they can construct
     * a new method. It is advisable to use this method for many reasons.
     *
     * @author Balaji
     * @return Image in the form of Base64 String which can be appended directly to report
     */

    public static String takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
