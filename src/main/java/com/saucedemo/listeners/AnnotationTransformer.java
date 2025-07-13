package com.saucedemo.listeners;

import com.saucedemo.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Implements {@link org.testng.IAnnotationTransformer} to leverage certain functionality like updating the annotations of test
 * methods at runtime.
 * This listener is used to set the Test annotation parameters at run time. So far each @Test these parameters are passed
 * <pre>Please make sure to add the listener details in the testng-dataprovider.xml file</pre>
 *
 * @author Balaji
 * @see com.saucedemo.utils.DataProviderUtils
 */

public class AnnotationTransformer implements IAnnotationTransformer {

    /**
     * Helps in setting the DataProvider, DataProvider class and retry analyser annotation to all the test methods
     * at run time.
     */

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataProviderUtils.class);
        annotation.setRetryAnalyzer(RetryFailedTests.class); //Enable only if you want to retry failed Tests
    }
}
