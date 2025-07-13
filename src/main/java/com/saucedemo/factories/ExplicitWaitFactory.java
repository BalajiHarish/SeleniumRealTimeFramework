package com.saucedemo.factories;

import com.saucedemo.constants.FrameworkConstants;
import com.saucedemo.driver.DriverManager;
import com.saucedemo.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Explicit wait factory produces different waits before operating on WebElement
 *
 * @author Balaji
 */

public final class ExplicitWaitFactory {

    /**
     * Private constructor to avoid external instantiation
     */
    private ExplicitWaitFactory() {}

    /**
     *
     * @author Balaji
     * @param waitStrategy Strategy to be applied to find a WebElement {@link com.saucedemo.enums.WaitStrategy}
     * @param by By locator of the WebElement
     * @return WebElement Locates and return the WebElement
     */

    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {

        WebElement element = null;

        if(waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if(waitStrategy == WaitStrategy.PRESENT) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if(waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if(waitStrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }

        return element;
    }
}
