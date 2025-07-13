package com.saucedemo.tests;

import com.saucedemo.driver.DriverClass;
import com.saucedemo.utils.PropertyUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() {}

    @BeforeMethod
    protected void setUp() {
        DriverClass.initDriver(PropertyUtils.getValue("BROWSER"));
    }

    @AfterMethod
    protected void tearDown() {
        DriverClass.quitDriver();
    }

}
