//package com.saucedemo.extent_reports;
//
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.saucedemo.constants.FrameworkConstants;
//import com.saucedemo.enums.TestCategories;
//
//import java.util.Objects;
//
///**
// * Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}
// * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal
// * variable for providing thread safety.
// *
// * @author Balaji
// * @see com.saucedemo.listeners.ListenerClass
// * @see com.saucedemo.annotations.FrameworkAnnotations
// */
//
//public final class ExtentReports {
//
//    /**
//     * Private constructor to avoid external instantiation
//     */
//
//    private ExtentReports() {}
//
//    private static com.aventstack.extentreports.ExtentReports extent;
//
//    /**
//     * Set the initial configuration for the Extent Reports and decides the report generation path.
//     * @author Balaji
//     */
//
//    public static void initReports() {
//        if(Objects.isNull(extent)) {
//            extent = new com.aventstack.extentreports.ExtentReports();
//            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportsFilePath());
//            extent.attachReporter(spark);
//            spark.config().setTheme(Theme.STANDARD);
//            spark.config().setDocumentTitle("SauceDemo Automation Results");
//            spark.config().setReportName("SauceDemo UI Test Report");
//        }
//    }
//
//    /**
//     * Flushing the extent_reports ensures extent logs are reflected properly.
//     * Opens the report in the default desktop browser.
//     * Sets the ThreadLocal variable to default value
//     * @author Balaji
//     */
//
//    public static void flushReports() {
//        if (Objects.nonNull(extent)) {
//            extent.flush();
//        }
//        ExtentManager.unload();
//    }
//
//    /**
//     * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
//     * @author Balaji
//     * @param testCaseName Test Name that needs to be reflected in the report
//     */
//
//    public static void createTest(String testCaseName) {
//        ExtentManager.setExtentTest(extent.createTest(testCaseName));
//    }
//
//    /**
//     * Adds the category a particular test case belongs to.
//     * Gives a clear idea of Group Vs Percentage success metrics.
//     * @author Balaji
//     * @param testCategories category a particular test case belongs to.
//     */
//
//    public static void addTestCategories(TestCategories[] testCategories) {
//        for(TestCategories testCategory : testCategories)
//            ExtentManager.getExtentTest().assignCategory(testCategory.toString());
//    }
//}
