package org.dutesting.Selenium_Basic02;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex03_SeleniumWaits {

    // Locators - Find the Web elements
// Open the URL https://app.vwo.com/#/login
// Find the Email id** and enter the email as **admin@admin.com**
// Find the Pass inputbox** and enter passwrod as **admin**.
// Find and Click on the submit button
// Verify that the error message is shown "Your email, password, IP address or location did not match"


    @Test
    @Owner("Durgesh Sawant")
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

        // Thread.sleep(4000);  //Implicit Wait (Not Recommended)

        //Explicit Wait -Waits for a specific condition to be met before proceeding.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait until the error message is visible
        WebElement error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-content")));

/*
        //Fluent Wait -Similar to explicit wait but allows polling intervals(frequency) and can ignore specific exceptions.
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)) //frequency to fins element
                .ignoring(NoSuchElementException.class);

        WebElement element = driver.findElement(By.className("notification-box-content"));
*/

        //WebElement error_message = driver.findElement(By.className("notification-box-content"));
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
        driver.quit();
    }
}






