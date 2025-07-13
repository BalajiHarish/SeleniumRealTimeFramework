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

public final class DriverFactory {

    private DriverFactory() {
    }

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
