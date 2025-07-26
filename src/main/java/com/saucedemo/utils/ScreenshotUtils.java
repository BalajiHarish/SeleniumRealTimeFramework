package com.saucedemo.utils;

import com.saucedemo.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Utility to take base64 screenshot.
 *
 * @author Balaji
 * @see com.saucedemo.allure_reports.AllureLogger
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
     * @return Image in the form of Base64 String which can be appended directly to report - not yet implemented
     * @author Balaji
     */

    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

//    @Attachment(value = "Screenshot (Base64)", type = "text/html")
//    public static String attachScreenshotBase64(byte[] screenshotBytes) {
//        String base64Image = Base64.getEncoder().encodeToString(screenshotBytes);
//        return "<img src='data:image/png;base64," + base64Image + "'/>";
//    }
}
