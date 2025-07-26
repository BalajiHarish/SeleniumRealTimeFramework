package com.saucedemo.enums;

/**
 * Enums to restrict the values allowed for grouping the tests.
 * <p>
 * This enum is used to categorize tests into different groups such as SMOKE and REGRESSION to used in extent reports.
 * But the framework is implemented with allure reports since extent report is sunset,
 * so this enum is not used in the current implementation.
 * This test categories can be achieved using its allure annotations.
 *
 * @author Balaji
 * @see com.saucedemo.annotations.FrameworkAnnotations
 */

public enum TestCategories {

    SMOKE,
    REGRESSION;
}
