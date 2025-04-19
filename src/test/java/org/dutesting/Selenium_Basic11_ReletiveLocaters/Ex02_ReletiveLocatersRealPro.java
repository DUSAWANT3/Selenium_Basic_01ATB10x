package org.dutesting.Selenium_Basic11_ReletiveLocaters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Ex02_ReletiveLocatersRealPro {

    @Test
    public void reletiveLocaters() throws InterruptedException {

        System.out.println("Real-time Most Polluted Cities in The India 2025");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        searchBox.sendKeys("india" + Keys.ENTER);

        Thread.sleep(5000);

        List<WebElement> locations = driver.findElements(By.cssSelector("div.location-name > p"));
        for (WebElement location : locations) {

            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(location)).getText();
            String aqi = driver.findElement(with(By.tagName("span")).toRightOf(location)).getText();
            System.out.println("| +" + rank + " | " + location.getText() + " | " + aqi + " | ");
        }
        driver.close();
    }
}