package org.dutesting.Selenium_Basic19_Upload_And_Download_File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class Upload_And_Download {
    private static final Logger log = LoggerFactory.getLogger(Upload_And_Download.class);
     @Test
    public void test() throws IOException {
        //	Task 1- Download the Excel file
        //	Task 2- Download the sheet, update the value, and save
        //	Task 3- Upload the file
        //	Task 4- and verify updated data in a file, which was updated on the page
         String fruitName = "Apple";
         String updatedValue = "555";
         String fileName = "C:\\Users\\durge\\Downloads\\downloadtest.xlsx";
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        driver.manage().window().maximize();

        //Download - click on download button
        driver.findElement(By.id("downloadButton")).click();

        //Update or Edit Excel -get ColoumNumber of prise -ger rowNumber of "Apple" ->updateExcel with row,coloum
         int col  = getColumnNumber(fileName,"Price");
         int row = getRowNumber(fileName,fruitName);
         Assert.assertTrue(UpdateCell(fileName,row,col,updatedValue));

        //Upload
        WebElement upload = driver.findElement(By.id("fileinput"));
        upload.sendKeys(fileName);

        //Wait for sucess message disperser
       By toastLocate = By.xpath("//div[@class=\"Toastify__toast-body\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocate));
        String toastText = driver.findElement(toastLocate).getText();
        System.out.println(toastText);
        Assert.assertEquals(toastText,"Updated Excel Data Successfully.");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocate));

        //Verify updated excel data showing in the web table
         String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getDomAttribute("data-column-id");
        String actualPrice = driver.findElement(By.xpath("//div[contains(text(),'"+fruitName+"')]/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
        Assert.assertEquals(updatedValue,actualPrice);
         System.out.println(actualPrice);

    driver.close();
    }

    private boolean UpdateCell(String fileName, int row, int col, String updatedValue) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheetAt(0);
         Row rowField = sheet.getRow(row-1);
         Cell cellField = rowField.getCell(col-1);
         cellField.setCellValue(updatedValue);
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        workbook.close();
        fis.close();
        return true;
     }

    private int getRowNumber(String fileName, String fruitName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        int k =1;
        int rowIndex =-1;
        while (rows.hasNext()){
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();

            while (cells.hasNext()){
                Cell cell = cells.next();
                if(cell.getCellType()== CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(fruitName)){
                   rowIndex =k;
                }
            }
            k++;
        }
         return rowIndex;
    }


    private int getColumnNumber(String fileName, String colName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row firstRow = sheet.getRow(0);

        int colIndex = -1;
        for (int i = 0; i < firstRow.getLastCellNum(); i++) {
            Cell cell = firstRow.getCell(i);
            if (cell != null && cell.getCellType() == CellType.STRING &&
                    cell.getStringCellValue().equalsIgnoreCase(colName)) {
                colIndex = i;
                break;
            }
        }

        workbook.close();
        fis.close();

        if (colIndex == -1) throw new RuntimeException("Column '" + colName + "' not found!");
        return colIndex;
    }

}
