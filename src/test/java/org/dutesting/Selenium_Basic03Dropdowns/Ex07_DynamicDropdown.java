package org.dutesting.Selenium_Basic03Dropdowns;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class Ex07_DynamicDropdown {
    @Test
    @Description("Verify and select Dropdoen Box")
    public void HaandleDropdon1() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //Handle Dynamic Dropdown

        driver.quit();
    }
}

