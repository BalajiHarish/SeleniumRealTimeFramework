package com.saucedemo.listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.saucedemo.allure_reports.AllureLogger;
import com.saucedemo.utils.PropertyUtils;
import com.saucedemo.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class TestListenerClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        if(PropertyUtils.getValue("FAILEDSTEPSCREENSHOT").equalsIgnoreCase("yes")) {
            Allure.attachment(UUID.randomUUID().toString(), new ByteArrayInputStream(ScreenshotUtils.takeScreenshot()));
            ChainTestListener.embed(ScreenshotUtils.takeScreenshot(), "image/png");
            AllureLogger.fail("Test failed: " + result.getMethod().getMethodName());
        } else {
            AllureLogger.fail("Test failed: " + result.getMethod().getMethodName());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if(PropertyUtils.getValue("PASSEDSTEPSCREENSHOT").equalsIgnoreCase("yes")) {
            Allure.attachment(UUID.randomUUID().toString(), new ByteArrayInputStream(ScreenshotUtils.takeScreenshot()));
            AllureLogger.pass("Test passed: " + result.getMethod().getMethodName());
        } else {
            AllureLogger.pass("Test passed: " + result.getMethod().getMethodName());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if(PropertyUtils.getValue("SKIPPEDSTEPSCREENSHOT").equalsIgnoreCase("yes")) {
            Allure.attachment(UUID.randomUUID().toString(), new ByteArrayInputStream(ScreenshotUtils.takeScreenshot()));
            AllureLogger.info("Test skipped: " + result.getMethod().getMethodName());
        } else {
            AllureLogger.info("Test skipped: " + result.getMethod().getMethodName());
        }
    }

}
