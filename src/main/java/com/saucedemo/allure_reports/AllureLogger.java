package com.saucedemo.allure_reports;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AllureLogger {

    public static void pass(String message) {
        Allure.step("✅ PASS: " + message);
    }

    public static void fail(String message) {
        Allure.step("❌ FAIL: " + message);
    }

    public static void info(String message) {
        Allure.step("ℹ️ INFO: " + message);
    }

}
