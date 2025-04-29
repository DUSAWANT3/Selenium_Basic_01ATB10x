package org.dutesting.Selenium_Basic17_StrimLamda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Ex02 {

    @Test
    public void greenKart() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers"); //URL
        driver.manage().window().maximize();
        //in search box search the veggi name and validate the same filter in table and Validate

        String veggiName = "Almond";
        driver.findElement(By.id("search-field")).sendKeys(veggiName);

        List<WebElement> allVeggi = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList = allVeggi.stream().filter(n -> n.getText().contains(veggiName))
                .collect(Collectors.toList());

        Assert.assertEquals(allVeggi.size(), filteredList.size());

        driver.quit();
    }
}