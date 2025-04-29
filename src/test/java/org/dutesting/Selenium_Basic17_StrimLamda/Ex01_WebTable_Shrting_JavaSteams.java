package org.dutesting.Selenium_Basic17_StrimLamda;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Ex01_WebTable_Shrting_JavaSteams {

    @Test
    public void greenKart() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers"); //URL
        driver.manage().window().maximize();

        //Click on "Veg/fruit name" column to short the WebTable
        driver.findElement(By.xpath("//tr/th[1]")).click();
        //Capture all webElements into List
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
        //Capture text of all webElements  into new list
        List<String> originalList = elementsList.stream().map(n -> n.getText()).collect(Collectors.toList());
        //short in the list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        //Compare Original and Sorted list
        Assert.assertEquals(originalList, sortedList);

//Scan the name column with get text --if it "Beans" -- print thr Prise
        //if the Veggi not found in first page click on Next button and search use Do While  loop
        List<String> price;
        do {
            List<WebElement> elementsList1 = driver.findElements(By.xpath("//tr/td[1]"));
            price = elementsList1.stream()
                    .filter(s -> s.getText().contains("Orange"))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());

            price.forEach(s -> System.out.println(s));
            if (price.size() < 1) {
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        }while (price.size() < 1);

        driver.quit();
    }

    private static String getPriceVeggie(WebElement s) {
        String veggiValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return veggiValue;
    }
}

