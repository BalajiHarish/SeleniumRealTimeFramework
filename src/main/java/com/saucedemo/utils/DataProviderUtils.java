package com.saucedemo.utils;

import com.saucedemo.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Holds the data provider for all the test cases in the framework.
 *
 * @author Balaji
 */

public final class DataProviderUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private DataProviderUtils() {}

    private static List<Map<String, String>> list = new ArrayList<>();

    /**
     * Acts as a data provider for all the test cases.
     * Parallel=true indicates that each of the iteration will run in parallel.
     *
     * @author Balaji
     * @param m {@link Method} holds the information about the testcases at runtime
     * @return Object[] containing the List. Each index of the list contains HashMap and each of them
     * contains the test data needed to run the iterations.
     *
     *
     * @see com.saucedemo.tests;
     * @see com.saucedemo.listeners.AnnotationTransformer
     */

    @DataProvider(parallel=true)
    public static Object[] getData(Method m) {

        String testName = m.getName();

        if(list.isEmpty()) //This line is to avoid reading the Excel file multiple times
            list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDatasheet());

        List<Map<String, String>> filteredList = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).get("testname").equalsIgnoreCase(testName) &&
                list.get(i).get("execute").equalsIgnoreCase("yes")) {
                    filteredList.add(list.get(i));
            }
        }

        return filteredList.toArray();
    }

}
