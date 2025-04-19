package org.dutesting.Selenium_BasicProject03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Pro09_browserstackFileUpload {
    @Test

    public void fileUpload() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app-automate.browserstack.com/dashboard/v2/getting-started");
        driver.manage().window().maximize();

        //Login to the system
        driver.findElement(By.id("user_email_login")).sendKeys("duonline02@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("Abc@123");
        driver.findElement(By.id("user_submit")).click();
    }
}

