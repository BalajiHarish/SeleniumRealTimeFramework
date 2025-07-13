package com.saucedemo.utils;

import com.saucedemo.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class to read or write to excel.
 *
 * @author Balaji
 * @see com.saucedemo.listeners.MethodInterceptor
 * @see DataProviderUtils
 */

public final class ExcelUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private ExcelUtils() {}

    /**
     * Encapsulates all the value from the mentioned Excel sheet and store it in
     * List holding HashMaps. Key for the map in the column header in the Excel sheet.
     *
     * @author Balaji
     * @param sheetName Excel sheet name to read the value from
     * @return List where each index holds a map and Each map holds the details about the test
     * TODO create reusable methods
     */

    public static List<Map<String,String>> getTestDetails(String sheetName){

        List<Map<String,String>> list = null;

        try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {

            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int lastrownum = sheet.getLastRowNum();
            int lastcolnum = sheet.getRow(0).getLastCellNum();

            Map<String,String> map = null;
            list = new ArrayList<>();

            for(int i=1; i<=lastrownum; i++) {
                map = new HashMap<>();
                for(int j=0;j<lastcolnum;j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
