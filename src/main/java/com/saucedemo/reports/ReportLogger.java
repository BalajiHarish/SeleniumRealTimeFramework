//package com.saucedemo.reports;
//
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.saucedemo.utils.PropertyUtils;
//import com.saucedemo.utils.ScreenshotUtils;
//
///**
// * Report Logger class helps to log pass,skip and fail steps in the reports.
// * Based on the boolean value given in the Config.properties file for screenshot key, screenshots will be attached to each step
// *
// * @author Balaji
// * @see com.saucedemo.listeners.ListenerClass
// */
//
//public final class ReportLogger {
//
//    private ReportLogger() {}
//
//    public static void pass(String message) {
//        if(PropertyUtils.getValue("PASSEDSTEPSCREENSHOT").equalsIgnoreCase("yes")) {
//            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.takeScreenshot()).build());
//        } else {
//            ExtentManager.getExtentTest().pass(message);
//        }
//    }
//
//    public static void fail(String message) {
//        if(PropertyUtils.getValue("FAILEDSTEPSCREENSHOT").equalsIgnoreCase("yes")) {
//            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.takeScreenshot()).build());
//        } else {
//            ExtentManager.getExtentTest().fail(message);
//        }
//    }
//
//    public static void skip(String message) {
//        if(PropertyUtils.getValue("SKIPPEDSTEPSCREENSHOT").equalsIgnoreCase("yes")) {
//            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.takeScreenshot()).build());
//        } else {
//            ExtentManager.getExtentTest().skip(message);
//        }
//    }
//}
