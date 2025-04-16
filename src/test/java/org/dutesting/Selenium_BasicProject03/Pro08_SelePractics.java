package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Pro08_SelePractics {
    @Test
    @Description("Verify and practics the web elements Box")
    public void HaandleDropdon1() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Task -1 -count the Radio butuns on Page -select and verify Radio 2
        List<WebElement> radioButuns = driver.findElements(By.xpath("//input[@name=\"radioButton\"]"));
        System.out.println(radioButuns.size() + "  = Count of Radio butuns");

        for (WebElement radioButun : radioButuns) {
            System.out.println(radioButun.getDomAttribute("value")); //To print the all radio but names
            String radioButName = radioButun.getDomAttribute("value");
            if (radioButName.equalsIgnoreCase("radio2")) {
                radioButun.click();
                Assert.assertTrue(radioButun.isSelected());
            }
        }

        //Task 2-  -select all Checkbox on Page and verify
        //Select one checkbox first
        WebElement option2 = driver.findElement(By.id("checkBoxOption2"));
        option2.click();

        // Get all checkboxes within the fieldset
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//fieldset//input[@type=\"checkbox\"]"));
        for (WebElement checkbox : checkBoxes) {
            String value = checkbox.getDomAttribute("value");
            if (checkbox.isSelected()) {
                System.out.println(value + " is already selected");
            } else {
                checkbox.click();
                System.out.println(value + " is now selected");
            }
        }

        //Task -3 Alert
    }
}

