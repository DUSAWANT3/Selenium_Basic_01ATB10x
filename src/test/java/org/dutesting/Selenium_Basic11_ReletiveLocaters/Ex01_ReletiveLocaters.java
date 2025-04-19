package org.dutesting.Selenium_Basic11_ReletiveLocaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Ex01_ReletiveLocaters {

    @Test
    public void reletiveLocaters(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");
        //click on sign in but
        WebElement email_AddressField = driver.findElement(By.id("login-username"));
        email_AddressField.sendKeys("ABC@gmail.com");

        //using Reletive Locataers find element on Page
       WebElement password_Field = driver.findElement(with(By.name("password")).below(email_AddressField));
       password_Field.sendKeys("Password123");

        WebElement signIn_But = driver.findElement(with(By.id("js-login-btn")).below(password_Field));
        signIn_But.click();


     WebElement error_Msg =driver.findElement(with(By.id("js-notification-box-msg")).above(email_AddressField));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(error_Msg));

        System.out.println(error_Msg.getText());

        driver.close();
    }
}
