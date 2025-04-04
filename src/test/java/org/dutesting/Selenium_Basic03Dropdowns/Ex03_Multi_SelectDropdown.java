package org.dutesting.Selenium_Basic03Dropdowns;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex03_Multi_SelectDropdown {

    @Test
    @Description("Verify Multiselect Dropdown Box")

    public void HaandleDropdon() {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testautomationcentral.com/demo/dropdown.html");
        //Click on multi select  dropdown box but-
        driver.findElement(By.xpath("//button[@data-target=\"multi-select-dropdown\"]")).click();

        //MultiSelect Dropdown Allows selecting multiple values.
        //Handling using Select Class

        WebElement Multiselect = driver.findElement(By.xpath("//select[@class=\"form-multiselect block w-full mt-1\"]"));
        Select select = new Select(Multiselect);

        select.selectByVisibleText("Option 2");
        select.selectByVisibleText("Option 3");
        select.selectByVisibleText("Option 4");

        //deselect the selected option
        select.deselectByVisibleText("Option 3");

        //get all selected options
        List<WebElement> selectedoption = select.getAllSelectedOptions();

        //extract text values
        List<String> selectedValues = selectedoption.stream().map(WebElement::getText).collect(Collectors.toList());

        //Verify the selected values
        List<String> expectedvalues = Arrays.asList("Option 2","Option 4");
        Assert.assertEquals(selectedValues,expectedvalues,"Selected values are Incorrect!");

        System.out.println(selectedValues);
        driver.close();
    }
}

