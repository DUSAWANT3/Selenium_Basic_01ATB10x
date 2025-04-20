package org.dutesting.Selenium_Basic12_handleShadowDom;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Ex01_handleShadowDom {

    @Test
    public void handleShadowDom() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://books-pwakit.appspot.com/"); // sample page with Shadow DOM
        driver.manage().window().maximize();

        // Step 1: Find shadow host
        WebElement shadowHost = driver.findElement(By.tagName("book-app"));

        Thread.sleep(2000);
        // Step 2: Get shadow root
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

        // Step 3: Find element inside shadow DOM
        WebElement input = shadowRoot.findElement(By.cssSelector("input#input"));

        input.sendKeys("Durgesh rocks!");

        driver.quit();
    }
}
