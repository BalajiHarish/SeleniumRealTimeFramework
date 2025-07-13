//package com.saucedemo.reports;
//
//import com.aventstack.extentreports.ExtentTest;
//
//import java.util.Objects;
//
///**
// * ExtentManager class helps to achieve thread safety for the {@link ExtentTest} instance.
// *
// * @author Balaji
// * @see com.saucedemo.driver.DriverClass
// */
//
//public class ExtentManager {
//
//    /**
//     * Private constructor to avoid external instantiation
//     */
//
//    private ExtentManager() {}
//
//    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;
//
//    /**
//     * Returns the thread safe {@link ExtentTest} instance fetched from ThreadLocal variable.
//     * @author Balaji
//     * @return Thread safe {@link ExtentTest} instance.
//     */
//
//    static ExtentTest getExtentTest() {
//        return extTest.get();
//    }
//
//    /**
//     * Set the {@link ExtentTest} instance to thread local variable
//     *
//     * @author Balaji
//     * @param test {@link ExtentTest} instance that needs to saved from Thread safety issues.<p>
//     */
//
//    static void setExtentTest(ExtentTest test) {
//        if(Objects.nonNull(test)) {
//            extTest.set(test);
//        }
//    }
//
//    /**
//     * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
//     * It is much safer than assigning null value to ThreadLocal variable.
//     * @author Balaji
//     */
//
//    static void unload() {
//        extTest.remove();
//    }
//}
