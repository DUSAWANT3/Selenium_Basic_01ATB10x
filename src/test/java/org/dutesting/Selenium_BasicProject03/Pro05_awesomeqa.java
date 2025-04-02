package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Pro05_awesomeqa {

    @Test
    @Description("Verify and automate awesomeqa page elements")
    @Owner("Durgesh Sawant")
    public void AutomatesawesomeqaElements(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        driver.manage().window().maximize();
        //verify the URL
        String URL = "https://awesomeqa.com/practice.html";
        Assert.assertEquals(driver.getCurrentUrl(),URL);

        WebElement FirstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        FirstName.sendKeys("OK");

        WebElement LastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        LastName.sendKeys("RAJ");

        //Click on radio button
        driver.findElement(By.xpath("//input[@id=\"sex-0\"]")).click();

        driver.findElement(By.xpath("//input[@id=\"exp-2\"]")).click();

        driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("02/04/2025");

        List<WebElement> ProfessionCheckbox = driver.findElements(By.xpath("//input[@name=\"profession\"]"));
        ProfessionCheckbox.get(1).click();

        List<WebElement> ToolCheckbox = driver.findElements(By.xpath("//input[@name=\"tool\"]"));
        ToolCheckbox.get(0).click();
        ToolCheckbox.get(2).click();

        driver.close();
    }
}
