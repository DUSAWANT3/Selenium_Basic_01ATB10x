package org.dutesting.Selenium_GreenKart;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Exo1_GreenKart {

    @Test
    @Description("Verify and Add Items in Cart")
    //GreenCart is E-commerce website
    public void greenKart() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/"); //URL
        driver.manage().window().maximize();

        //Here we can ot directly find out the particular Add to Cart button --shoa 30 matches??
        //Firstly take all product name on page and then get indexes for that
        //Using this because in future some product add/delete no impact i=on script
        //We convert the String[] array to a List<String>
        //the List interface in Java provides useful methods like contains() — which is not available for plain arrays (String[]).

        int j = 0;
        // Items to be added in the cart
        String[] itemsNeeded = {"Brocolli", "Cucumber", "Beetroot", "Mango"};

        // Capture all product names on the page
        List<WebElement> itemNames = driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));

        Thread.sleep(2000);

        for (int i = 0; i < itemNames.size(); i++) {
            String[] productName = itemNames.get(i).getText().split("-");
            // Format: Brocolli - 1 Kg => we split and trim to get only name
            String formatedName = productName[0].trim();

            List itemNeededList = Arrays.asList(itemsNeeded);//Convert String array into list

            if (itemNeededList.contains(formatedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
        driver.quit();
    }
}

