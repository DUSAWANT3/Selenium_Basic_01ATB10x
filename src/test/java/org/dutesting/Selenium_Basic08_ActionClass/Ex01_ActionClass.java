package org.dutesting.Selenium_Basic08_ActionClass;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex01_ActionClass {

    @Test
    @Description("Verify and Validate Action Class")
    //GreenCart is E-commerce website
    public void ActionClass() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/"); //URL
        driver.manage().window().maximize();

    }
}
