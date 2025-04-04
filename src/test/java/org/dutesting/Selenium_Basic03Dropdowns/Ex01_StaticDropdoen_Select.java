package org.dutesting.Selenium_Basic03Dropdowns;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex01_StaticDropdoen_Select {
    @Test
    @Description("Verify and select Dropdoen Box")
    public void HaandleDropdon(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testautomationcentral.com/demo/dropdown.html");
        //Click on simple dropdown box but-
        driver.findElement(By.xpath("//button[@data-target=\"simple-dropdown\"]")).click();

        //Static Dropdown - This is a traditional dropdown with <select> and <option> tags.
        //Handle using Select Class //div[@id="simple-dropdown"]//select

        WebElement SimpleDropdown = driver.findElement(By.xpath("//div[@id=\"simple-dropdown\"]//select"));
        Select select = new Select(SimpleDropdown);

        //Select by visible text
        select.selectByVisibleText("Option 3");

        // Get selected option
        String selectedValue = select.getFirstSelectedOption().getText();
        // Verify the selected value
        Assert.assertEquals(selectedValue, "Option 3", "Selected value is incorrect!");

        //Select by Value Attribute
        select.selectByValue("option2");

        //Select by Index
        select.selectByIndex(0);
        String selectedValue1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedValue1, "Option 1", "Selected value is incorrect!");

        driver.close();
    }
}
