package org.dutesting.Selenium_Basic08_ActionClass;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class Ex01_ActionClass {

    @Test
    @Description("Verify and Validate Action Class")

    public void ActionClass() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/text-box"); //URL
        driver.manage().window().maximize();

        Thread.sleep(2000);
        //Key -Action Classes
        //Press Shift button and send Key  - so it type in Capitial
        WebElement firstName = driver.findElement(By.id("userName"));

        Actions actions = new Actions(driver);
       actions
               .keyDown(Keys.SHIFT) //Press the Shift but
               .sendKeys(firstName,"durgesh")
               .keyUp(Keys.SHIFT).build().perform(); //key Up- release the But

    }
}
