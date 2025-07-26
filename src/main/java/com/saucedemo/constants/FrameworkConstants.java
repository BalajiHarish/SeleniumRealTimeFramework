package com.saucedemo.constants;

import com.saucedemo.utils.PropertyUtils;

/**
 * Framework Constants holds all the constant values used within the framework. If some value needs to be changed
 * or modified often, then it should be stored in the property files
 *
 * Making the class as final to restrict anyone from extending this class
 *
 * @author Balaji
 * @see com.saucedemo.utils.PropertyUtils
 */

public final class FrameworkConstants {

    /**
     * Private constructor to avoid external instantiation
     */

    private FrameworkConstants() {}

    private static final int EXPLICITWAIT_IN_SECONDS = 10;

    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCES_PATH + "/config/config.properties";
    private static final String REPORTS_PATH = System.getProperty("user.dir") + "/extent_reports/";
    private static final String EXCELPATH = RESOURCES_PATH + "/excel/testdata.xlsx";

    private static final String RUNMANGERSHEET = "RUNMANAGER";
    private static final String ITERATIONDATASHEET = "DATA";

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static int getExplicitWaitTime() {
        return EXPLICITWAIT_IN_SECONDS;
    }

    public static String getExcelpath() {
        return EXCELPATH;
    }

    public static String getIterationDatasheet() {
        return ITERATIONDATASHEET;
    }

    public static String getRunmangerDatasheet() {
        return RUNMANGERSHEET;
    }

    /**
     *
     * @author Balaji
     * @return  If Override extent_reports value in the property file is "NO",then the timestamp will be appended
     */

    public static String getReportsFilePath() {
        if(PropertyUtils.getValue("OVERRIDEREPORTS").equalsIgnoreCase("yes")) {
            return REPORTS_PATH + "index.html";
        } else {
            return REPORTS_PATH + System.currentTimeMillis() + "_" + "index.html";
        }
    }
}
