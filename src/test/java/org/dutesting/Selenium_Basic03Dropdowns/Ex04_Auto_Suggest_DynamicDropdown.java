package org.dutesting.Selenium_Basic03Dropdowns;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ex04_Auto_Suggest_DynamicDropdown {

    @Test
    @Description("Verify auto suggest Dynamic Dropdown Box")
    //Enter search text in the input field.
    //Capture all suggested values from the dropdown.
    //Match and click the correct option if it matches the expected value.
    //Verify the selected value in the input field.


    public void HaandleDropdon() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://weboverhauls.github.io/demos/autosuggest/?");

        //Step 1: Locate the search box and enter text
        WebElement SearchBox = driver.findElement(By.xpath("//input[@id=\"search\"]"));
        SearchBox.sendKeys("In");

       // Thread.sleep(2000); // Wait for suggestions to load
        // Step 2: Capture all suggested values
        List<WebElement> suggestions = driver.findElements(By.xpath("//div/ul/li[@role=\"option\"]"));

        // Step 3: Print all suggested values and select the desired one
        String expectedValue = "Independence";
        boolean isMatched = false;

        for (WebElement suggestion : suggestions) {
            String suggestionText = suggestion.getText();
            System.out.println("Suggested Option: " + suggestionText);

            if (suggestionText.equalsIgnoreCase(expectedValue)) {
                suggestion.click();
                isMatched = true;
                break;
            }

        }
        // Step 4: Verify if the correct value is selected
        String selectedValue = SearchBox.getAttribute("value");
        Assert.assertEquals(selectedValue, expectedValue, "Selected value does not match expected!");

        // Close browser
        driver.quit();

    }
}