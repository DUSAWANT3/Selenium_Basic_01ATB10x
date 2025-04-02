package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pro04_OpenCartDemo {
    //Rejister on Opencart


    @Test
    @Description("Verify Open Cart Demo web Application")
    @Owner("Durgesh Sawant")
    public void OpenCartDemoVerify() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.opencart.com/index.php?route=common/home");

        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.opencart.com/index.php?route=common/home");

        //click on Register button
        WebElement RegisterButton = driver.findElement(By.xpath("//a[@class=\"btn btn-black navbar-btn\"]"));
        RegisterButton.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.opencart.com/index.php?route=account/register");

        WebElement UsernameField = driver.findElement(By.xpath("//*[@id=\"input-username\"]"));
        UsernameField.sendKeys("Raj123");

        WebElement FirstnameField = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        UsernameField.sendKeys("Raj");

        WebElement LastnameField = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        UsernameField.sendKeys("OK");

        WebElement EmailField = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        UsernameField.sendKeys("OKRAJ@email.com");


    }
}
