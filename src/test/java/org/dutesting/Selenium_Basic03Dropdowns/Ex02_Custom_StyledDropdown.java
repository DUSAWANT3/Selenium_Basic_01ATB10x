package org.dutesting.Selenium_Basic03Dropdowns;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class Ex02_Custom_StyledDropdown {

    @Test
    @Description("Verify Custom_Styled Dropdoen Box")

    public void HaandleDropdon() {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testautomationcentral.com/demo/dropdown.html");
        //Click on Styled dropdown box but-
        driver.findElement(By.xpath("//button[@data-target=\"styled-dropdown\"]")).click();

        //These dropdowns use <div>, <ul>, or <li> elements instead of <select>.
        //Handling using Click & List Items
        WebElement dropdown = driver.findElement(By.xpath("//div[@id=\"styled-dropdown\"]//select"));
        dropdown.click();

        WebElement option = dropdown.findElement(By.xpath("//div[@id=\"styled-dropdown\"]//select/option[@value=\"option2\"]"));
        option.click();

       //Verify the selected value
        String actualText = driver.findElement(By.xpath("//div[@id=\"styled-dropdown\"]//select")).getText();
      //  Assert.assertEquals(actualText,"Styled Option 2", "Selected value is incorrect!");
        System.out.println(actualText);
    }
}
