package org.dutesting.Selenium_Basic03Dropdowns;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class Ex06_PassengerDropdown {
    @Test
    @Description("Verify and select Dropdoen Box")
    public void HaandleDropdon1() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
       //Step 1- click on dropdown
        //step 2- Adult 1 auto selected - click on +  icon and select 4 using While loop
        //Step 3- Child aut-selected 0 click on + icon and select 2 use for loop
        //Step 4- Click on Done
        //Step 5- Verify "4 Adult, 2 Child"  selected

        WebElement passengerDropdown = driver.findElement(By.id("divpaxinfo"));
        passengerDropdown.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt")));

        //step 2- Adult 1 auto selected - click on +  icon and select 4 using While loop
        WebElement adult = driver.findElement(By.id("hrefIncAdt"));
        int a =1;

        while ( a < 4){
            adult.click();
            a++;
        }

        //Step 3- Child aut-selected 0 click on + icon and select 2 use for loop
        WebElement child = driver.findElement(By.id("hrefIncChd"));
        for(int i =0 ; i < 2; i++){
            child.click();
        }

        //Step 4- Click on Done
        driver.findElement(By.id("btnclosepaxoption")).click();

        //Step 5- Verify "4 Adult, 2 Child"  selected
        WebElement selectedValue = driver.findElement(By.id("divpaxinfo"));

        System.out.println(selectedValue.getText() +"--Pass");

        Assert.assertEquals(selectedValue.getText(),"4 Adult, 2 Child","Incorrect Passengers selected!");

        driver.quit();
    }
}

