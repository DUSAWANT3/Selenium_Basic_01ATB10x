package org.dutesting.Selenium_Basic03Dropdowns;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex05_StaticDropdown {
    @Test
    @Description("Verify and select Dropdoen Box")
    public void HaandleDropdon1() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Static Dropdown - This is a traditional dropdown with <select> and <option> tags.
        //Handle using Select Class //div[@id="simple-dropdown"]//select

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        staticDropdown.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Select select = new Select(staticDropdown);

        //1- Using Index select value
        select.selectByIndex(3);
        System.out.println(select.getFirstSelectedOption().getText() + "USD--Pass 1");

        //2-Using Text to select value
        select.selectByVisibleText("INR");
        System.out.println(select.getFirstSelectedOption().getText() + "INR--Pass 2");

        //3- Select by Value Attribute
        select.selectByValue("AED");
        System.out.println(select.getFirstSelectedOption().getText() + "AED--Pass 3");

        driver.quit();
    }
}

