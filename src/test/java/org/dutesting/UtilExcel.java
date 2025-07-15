package org.dutesting;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel {
    static Workbook book;
    static Sheet sheet;

    public static String SHEET_PATH = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
    //public static String SHEET_PATH = "C:\\Users\\durge\\IdeaProjects\\Selenium_Basic_1ATB10X\\src\\test\\resources\\TestData.xlsx";
    public static Object[][] getTestDataFromExcel(String sheetName) {
        try (FileInputStream file = new FileInputStream(SHEET_PATH)) {
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum(); // excluding header
            int colCount = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString(); // skip header
                }
            }
            return data;

        } catch (IOException e) {
            System.out.println("Either Data File not found or Workbook not loaded properly!");
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
