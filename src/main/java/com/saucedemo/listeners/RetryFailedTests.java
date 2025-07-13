package com.saucedemo.listeners;

import com.saucedemo.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implements {@link IRetryAnalyzer}.<p>
 * Helps in rerunning the failed tests.<p>
 * @author Balaji
 */

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    /**
     * Return true when needs to be retried and false otherwise.
     * Maximum will retry for one time.
     * Retry will happen if user desires to and set the value in the property file
     */

    @Override
    public boolean retry(ITestResult iTestResult) {

        boolean value = false;

        if(PropertyUtils.getValue("RETRYFAILEDTESTS").equalsIgnoreCase("Yes")) {
            value = count < retries;
            count++;
        }
        return value;
    }
}
