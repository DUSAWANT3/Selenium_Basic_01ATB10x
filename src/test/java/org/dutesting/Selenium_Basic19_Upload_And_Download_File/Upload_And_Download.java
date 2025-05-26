package org.dutesting.Selenium_Basic19_Upload_And_Download_File;

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

import java.time.Duration;

public class Upload_And_Download {
    private static final Logger log = LoggerFactory.getLogger(Upload_And_Download.class);
     @Test
    public void test() {
        //	Task 1- Download the Excel file
        //	Task 2- Download the sheet, update the value, and save
        //	Task 3- Upload the file
        //	Task 4- and verify updated data in a file, which was updated on the page
         String fruitName = "Apple";
         String fileName = "C:\\Users\\durge\\Downloads\\downloadtest.xlsx";
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        driver.manage().window().maximize();

        //Download - click on download button
        driver.findElement(By.id("downloadButton")).click();

        //Update or Edit Excel -get ColoumNumber of prise -ger rowNumber of "Apple" ->updateExcel with row,coloum
         int col  =getColumnNumber(fileName,"prise");
         int row = getRowNumber(fileName,fruitName);
         UpdateCell(fileName,row,col,"555");

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
        Assert.assertEquals("555",actualPrice);
         System.out.println(actualPrice);

    driver.close();
    }

    private void UpdateCell(String fileName, int row, int col, String number) {
     }

    private int getRowNumber(String fileName, String fruitName) {
         return 0;
    }

    private int getColumnNumber(String fileName, String prise) {
         return 0;
    }


}
