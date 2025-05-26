package org.dutesting.Selenium_Basic19_Upload_And_Download_File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Upload_And_Download {
    public static void main(String[] args) {

        //	Task 1- Download the Excel file
        //	Task 2- Download the sheet, update the value, and save
        //	Task 3- Upload the file
        //	Task 4- and verify updated data in a file, which was updated on the page

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        driver.manage().window().maximize();

        //Download - click on download button
        driver.findElement(By.id("downloadButton")).click();

        //Upload
        WebElement upload = driver.findElement(By.id("fileinput"));
        upload.sendKeys("C:\\Users\\durge\\Downloads\\downloadtest.xlsx");

     // driver.close();
    }
}
