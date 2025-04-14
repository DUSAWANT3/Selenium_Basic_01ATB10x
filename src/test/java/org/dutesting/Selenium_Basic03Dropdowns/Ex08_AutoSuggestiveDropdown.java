package org.dutesting.Selenium_Basic03Dropdowns;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class Ex08_AutoSuggestiveDropdown {
    @Test
    @Description("Verify and select Dropdown Box")
    public void handleDropdownSuggestion() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement inputBox = driver.findElement(By.id("autosuggest"));
        inputBox.sendKeys("Ind");

        // Wait for suggestions to load
        try {
            Thread.sleep(2000); // Not recommended in real projects, use WebDriverWait instead
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get all the suggested list items
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

        // Store and print all suggestions
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        // Select "India" from the suggestions
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }

        // Close the browser
        driver.quit();
    }

}
