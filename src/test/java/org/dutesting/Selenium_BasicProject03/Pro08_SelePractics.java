package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Pro08_SelePractics {
    @Test
    @Description("Verify and practics the web elements Box")
    public void HaandleDropdon1() throws InterruptedException {
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

        //Task -3 Alert simple alert
        String name = "Durgesh";
        driver.findElement(By.id("name")).sendKeys(name);
        //Click on alert button
        WebElement alertBut = driver.findElement(By.id("alertbtn"));
        alertBut.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        String alertMsg = driver.switchTo().alert().getText();
        System.out.println(alertMsg);
        Assert.assertTrue(alertMsg.contains(name)); //Verify the alert msg contain Name
        //accept the alert
        driver.switchTo().alert().accept();

        //Task 4- Static Dropdown
        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
        staticDropdown.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        Select select = new Select(staticDropdown);
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());
        //count of all options
        System.out.println(select.getOptions().size());

        // Get all options
        List<WebElement> options = select.getOptions();
        // Print each option text
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        //Task 5- Autosuggestive dropdown
        WebElement inputBox = driver.findElement(By.id("autocomplete"));
        inputBox.sendKeys("Ja");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        List<WebElement> autoSuggestions = driver.findElements(By.xpath("//div[@class=\"ui-menu-item-wrapper\"]"));
        for (WebElement option : autoSuggestions) {
            if (option.getText().equalsIgnoreCase("Japan")) {
                System.out.println(option.getText());
                option.click();
            }
        }

        driver.quit();
    }
}

