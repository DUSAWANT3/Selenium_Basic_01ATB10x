package org.dutesting.Selenium_Basic08_ActionClass;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Ex02_Scrolling_Action {
    //Selenium doesn't have a direct method like scroll(), but you can do it using:
    //1.	JavaScriptExecutor (most used)
    //2.	Actions class
    //3.	Keys class (Page Down, Arrow Keys)

    @Test
    public void ActionClass() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/text-box"); //URL
        driver.manage().window().maximize();
       Thread.sleep(2000);

        //1.	JavaScriptExecutor (most used)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);"); //scroll down 5oopx

       //2.	Actions class
        Actions actions = new Actions(driver);
       actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

        //3.	Keys class (Page Down, Arrow Keys)
        WebElement element = driver.findElement(By.id("submit"));
        element.sendKeys(Keys.PAGE_DOWN);

    }
}