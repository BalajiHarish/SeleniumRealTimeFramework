package com.saucedemo.driver;

import com.saucedemo.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * {@code DriverFactory} is a utility class responsible for creating and returning
 * {@link WebDriver} instances based on the specified browser and execution mode.
 * <p>
 * It supports both local and remote (Selenium Grid) execution.
 * The execution mode is determined by the <b>RUNMODE</b> property
 * configured in the project's property file.
 * </p>
 *
 * <p><b>Supported browsers:</b></p>
 * <ul>
 *     <li>Chrome</li>
 *     <li>Edge</li>
 *     <li>Firefox</li>
 * </ul>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * WebDriver driver = DriverFactory.getDriver("Chrome");
 * }</pre>
 *
 * <p>This class cannot be instantiated.</p>
 *
 * @author Balaji
 */

public final class DriverFactory {

    private DriverFactory() {
    }

    /**
     * Returns a {@link WebDriver} instance based on the specified browser name and execution mode.
     *
     * @param browser the name of the browser ("Chrome", "Edge", or "Firefox")
     * @return a configured {@link WebDriver} instance
     * @throws MalformedURLException if the Selenium Grid URL is malformed when using remote execution
     */

    public static WebDriver getDriver(String browser) throws MalformedURLException {

        WebDriver driver = null;
        String runMode = PropertyUtils.getValue("RUNMODE"); //If this is remote, script will execute in docker

        if(browser.equalsIgnoreCase("Chrome")) {
            if(runMode.equalsIgnoreCase("Remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(browser);
                driver =  new RemoteWebDriver(new URL(PropertyUtils.getValue("SELENIUMGRIDURL")), cap);
            }
            else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
            }
        } else if(browser.equalsIgnoreCase("Edge")) {
            if(runMode.equalsIgnoreCase("Remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(browser);
                driver =  new RemoteWebDriver(new URL(PropertyUtils.getValue("SELENIUMGRIDURL")), cap);
            }
            else {
                driver = new EdgeDriver();
            }
        } else if(browser.equalsIgnoreCase("Firefox")) {
            if(runMode.equalsIgnoreCase("Remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(browser);
                driver =  new RemoteWebDriver(new URL(PropertyUtils.getValue("SELENIUMGRIDURL")), cap);
            }
            else {
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
