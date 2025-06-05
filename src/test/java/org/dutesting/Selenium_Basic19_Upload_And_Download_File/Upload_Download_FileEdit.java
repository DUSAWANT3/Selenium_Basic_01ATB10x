package org.dutesting.Selenium_Basic19_Upload_And_Download_File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Upload_Download_FileEdit {

    private static final String FRUIT_NAME = "Apple";
    private static final String UPDATED_PRICE = "603";
    private static final String FILE_PATH = "C:\\Users\\durge\\Downloads\\download.xlsx";
    private static final String SHEET_NAME = "Sheet1";

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        // Step 1: Download the Excel
        driver.findElement(By.cssSelector("#downloadButton")).click();

        // Step 2: Update price in Excel
        int col = getColumnNumber(FILE_PATH, "Price");
        int row = getRowNumber(FILE_PATH, FRUIT_NAME);
        Assert.assertTrue(updateCell(FILE_PATH, row, col, UPDATED_PRICE));

        // Step 3: Upload the updated Excel
        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys(FILE_PATH);

        // Step 4: Wait for success message
        By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        String toastText = driver.findElement(toastLocator).getText();
        System.out.println("Toast Message: " + toastText);
        Assert.assertEquals(toastText, "Updated Excel Data Successfully.");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

        // Step 5: Verify UI data reflects the update
        String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
        String actualPrice = driver.findElement(By.xpath("//div[text()='" + FRUIT_NAME + "']/parent::div/parent::div/div[@id='cell-" + priceColumn + "-undefined']")).getText();
        System.out.println("Actual Price on Web: " + actualPrice);
        Assert.assertEquals(actualPrice, UPDATED_PRICE);

        driver.quit();
    }

    private static boolean updateCell(String filePath, int rowIdx, int colIdx, String newValue) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(SHEET_NAME);
        Row row = sheet.getRow(rowIdx);
        Cell cell = row.getCell(colIdx);
        cell.setCellValue(newValue);
        fis.close();

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();
        return true;
    }

    private static int getRowNumber(String filePath, String cellText) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(SHEET_NAME);
        Iterator<Row> rows = sheet.iterator();
        int rowIndex = 0;

        while (rows.hasNext()) {
            Row row = rows.next();
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(cellText)) {
                    workbook.close();
                    fis.close();
                    return rowIndex;
                }
            }
            rowIndex++;
        }

        workbook.close();
        fis.close();
        return -1;
    }

    private static int getColumnNumber(String filePath, String colName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(SHEET_NAME);
        Row firstRow = sheet.getRow(0);
        int colIndex = 0;

        for (Cell cell : firstRow) {
            if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(colName)) {
                workbook.close();
                fis.close();
                return colIndex;
            }
            colIndex++;
        }
        workbook.close();
        fis.close();
        return -1;
    }
}