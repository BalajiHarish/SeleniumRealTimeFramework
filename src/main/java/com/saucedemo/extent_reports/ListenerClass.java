//package com.saucedemo.listeners;
//
//import com.saucedemo.annotations.FrameworkAnnotations;
//import com.saucedemo.extent_reports.ExtentReports;
//import com.saucedemo.extent_reports.ReportLogger;
//import org.testng.ISuite;
//import org.testng.ISuiteListener;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
///**
// * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
// * Mostly used to help in extent report generation
// *
// * <pre>Please make sure to add the listener details in the testng-dataprovider.xml file</pre>
// *
// * @author Balaji
// */
//
//public class ListenerClass implements ITestListener, ISuiteListener {
//
//    /**
//     * Initialise the extent_reports with the file name
//     * @see ExtentReports
//     */
//
//    @Override
//    public void onStart(ISuite suite) {
//        ExtentReports.initReports();
//    }
//
//    /**
//     * Terminate the extent_reports
//     * @see ExtentReports
//     */
//    @Override
//    public void onFinish(ISuite suite) {
//        ExtentReports.flushReports();
//    }
//
//    /**
//     * Starts a test node for each testng test
//     * @see ExtentReports
//     * @see com.saucedemo.annotations.FrameworkAnnotations
//     */
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtentReports.createTest(result.getMethod().getMethodName());
//        ExtentReports.addTestCategories(result.getMethod().getConstructorOrMethod().getMethod()
//                        .getAnnotation(FrameworkAnnotations.class).testCategories());
//    }
//
//    /**
//     * Marks the test as pass and logs it in the report
//     * @see com.saucedemo.extent_reports.ReportLogger
//     */
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        ReportLogger.pass(result.getMethod().getMethodName() +" is passed");
//    }
//
//    /**
//     * Marks the test as fail,append base64 screenshot and logs it in the report
//     * @see com.saucedemo.extent_reports.ReportLogger
//     * @see com.saucedemo.utils.ScreenshotUtils
//     */
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        ReportLogger.fail(result.getMethod().getMethodName() +" is failed");
//        ReportLogger.fail(result.getThrowable().toString()); //To get only first line of error stack
//        //ReportLogger.fail(Arrays.toString(result.getThrowable().getStackTrace())); //To get entire error stack in extent_reports
//    }
//
//    /**
//     * Marks the test as skip and logs it in the report
//     * @see com.saucedemo.extent_reports.ReportLogger
//     */
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ReportLogger.skip(result.getMethod().getMethodName() +" is skipped");
//    }
//}
