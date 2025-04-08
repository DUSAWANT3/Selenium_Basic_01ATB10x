package org.dutesting.Selenium_Basic06_CustomCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ex01_CustomCalendar_DatePicker {
//Custom JavaScript Calendars (Most Common) -
//Click to open the calendar popup, then select a date
    //Step 1- Click the date field to open the calendar.
    //Step 2- Navigate to the appropriate month/year if necessary.
    //Step 3-Select the desired date
@Test
    public void Handle_CustomCalendar() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testautomationcentral.com/demo/date_picker.html");

//Step 1- Click the date field to open the calendar.
        driver.findElement(By.xpath("//*[@id=\"date-picker\"]")).click();

//Step 2- Navigate to the appropriate month/year if necessary.
        while (!driver.findElement(By.className("//*[@class=\"ui-datepicker-title\"]")).getText().contains("July 2025")) {
            driver.findElement(By.className("//a[@data-handler=\"next\"]")).click(); // or prevButton
        }
        // Step 3: Select the date
        List<WebElement> dates = driver.findElements(By.xpath("//*[@data-handler=\"selectDay\"]"));
        for (WebElement date : dates) {
            if (date.getText().equals("15")) {
                date.click();
                break;
            }
        }
    }
}
