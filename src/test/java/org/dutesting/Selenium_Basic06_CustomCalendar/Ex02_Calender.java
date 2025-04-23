package org.dutesting.Selenium_Basic06_CustomCalendar;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex02_Calender {

    @Test
    //GreenCart is E-commerce website
    public void calendar() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers"); //URL
        driver.manage().window().maximize();

        String monthNumber = "6";
        String date = "15";
        String year ="2027";

        //Click to Open a calendar window
        driver.findElement(By.xpath("//div[@class=\"react-date-picker__inputGroup\"]")).click();
        //Click on calendar month & year top side to open a  all  months
        driver.findElement(By.xpath("//span[contains(@class, 'react-calendar__navigation__label__labelText')]")).click();
        //Click on calendar year top side to open year
        driver.findElement(By.xpath("//span[contains(@class, 'react-calendar__navigation__label__labelText')]")).click();

        //Select and click on year
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        //Select Month findElements
        driver.findElements(By.xpath("//button[contains(@class,'react-calendar__year-view__months__month')]")).get(Integer.parseInt(monthNumber)-1).click();

        //Select date
        driver.findElement(By.xpath("//abbr[text()="+ date +"]")).click();

    }
}
