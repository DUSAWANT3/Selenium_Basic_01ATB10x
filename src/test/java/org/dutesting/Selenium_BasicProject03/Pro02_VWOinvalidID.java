package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pro02_VWOinvalidID {

            // Locators - Find the Web elements
// Open the URL https://app.vwo.com/#/login
// Find the Email id** and enter the email as **admin@admin.com**
// Find the Pass inputbox** and enter passwrod as **admin**.
// Find and Click on the submit button
// Verify that the error message is shown "Your email, password, IP address or location did not match"


    @Test
    @Description("To Verify the VWO login Funcanility with invalid ID")

    public void VerifyVWOLogin() throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.get("https://app.vwo.com/#/login");

        driver.manage().window().maximize();

        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
        //get tital
        System.out.println("Titl == " + driver.getTitle());

        WebElement emailAddress = driver.findElement(By.id("login-username"));
        emailAddress.sendKeys("admin@admin.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("admin");

        WebElement checkbox = driver.findElement(By.className("checkbox-radio-icon"));
        checkbox.click();

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        Thread.sleep(4000);


        WebElement error_message = driver.findElement(By.className("notification-box-content"));
        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");

       driver.quit();
    }
}
