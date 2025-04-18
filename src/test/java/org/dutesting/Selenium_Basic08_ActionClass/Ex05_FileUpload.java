package org.dutesting.Selenium_Basic08_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex05_FileUpload {
    //Selenium only supports the HTML file type in the Input tag
    //<input type="file" id="uploadFile">

    @Test

    public void fileUpload() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.testautomationcentral.com/demo/file_upload.html");
        driver.manage().window().maximize();

        WebElement uploadElement = driver.findElement(By.id("file-input"));

// Step 1: Provide absolute file path
        uploadElement.sendKeys("C:\\Users\\durge\\OneDrive\\Desktop\\SeleniumData");

// Step 2: Click Upload But
        driver.findElement(By.xpath("//button[@type=\"button\"]")).click();

 //Step 3- validation
        WebElement massage = driver.findElement(By.id("upload-message"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(massage));

        System.out.println(massage.getText());

        driver.quit();
    }
}