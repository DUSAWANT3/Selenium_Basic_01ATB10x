package org.dutesting.Selenium_Basic12_handleShadowDom;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Exo2 {
    @Test
    public void handleShadowDom() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/"); // sample page with Shadow DOM
        driver.manage().window().maximize();

        WebElement searchbox= driver.findElement(By.id("APjFqbt"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(searchbox));

        searchbox.sendKeys("Durgesh" + Keys.ENTER);
    }
}

