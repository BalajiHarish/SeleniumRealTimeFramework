package com.saucedemo.pages;

import com.saucedemo.driver.DriverManager;
import com.saucedemo.enums.WaitStrategy;
import com.saucedemo.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    /**
     * Locates element by given wait strategy, performs the clicking operation on WebElement and
     * writes the pass event to the extent report.
     * @author Balaji
     * @param by By Locator of the WebElement
     * @param waitStrategy Strategy to find WebElement. Known  strategies {@link com.saucedemo.enums.WaitStrategy}
     */

    protected void click(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.click();
        //ReportLogger.pass(elementName + " clicked successfully");
    }

    /**
     * Locates element by given wait strategy, sends the value to located WebElement and
     * writes the pass event to the extent report.
     * @author Balaji
     * @param by By Locator of the WebElement
     * @param text value to be sent the text box
     * @param waitStrategy Strategy to find WebElement. Known  strategies {@link com.saucedemo.enums.WaitStrategy}
     */

    protected void enterText(By by, String text, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.sendKeys(text);
        //ReportLogger.pass(text + " is entered successfully in " + elementName + " field");
    }

    /**
     * Identifies element by given path and returns a boolean value for the WebElement to be Displayed in the UI
     *
     * @author Balaji
     * @return returns a boolean value for the WebElement is Displayed in the UI
     */

    protected boolean isElementDisplayed(By by) {
        return DriverManager.getDriver().findElement(by).isDisplayed();
    }

    /**
     * Returns page title of webpage in String
     *
     * @author Balaji
     * @return Page title of the webpage where the selenium is currently interacting.
     */

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    /**
     * Returns Text of WebElement
     *
     * @author Balaji
     * @return Text of the WebElement where the selenium is currently interacting.
     */

    protected String getText(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        return element.getText();
    }

    /**
     * Returns current page url of webpage in String
     *
     * @author Balaji
     * @return Page url of the webpage where the selenium is currently interacting.
     */

    protected String getURL() {
        return DriverManager.getDriver().getCurrentUrl();
    }
}
