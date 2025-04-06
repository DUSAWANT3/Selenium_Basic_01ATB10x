package org.dutesting.Selenium_Basic05_SVG_Elements;

import io.qameta.allure.Description;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ex01_SVG_Elements {

     WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

    }

    @Test
    @Description("Verify the search with SVG icon resultes are visible.")
    public void test_Flipkart_Search_SVG_Icon(){
        driver.get("https://www.google.co.in/");
        
      //Step 1 - Enter the "mac" in inputBox.
       WebElement searchbox = driver.findElement(By.xpath("//*[@name=\"q\"]"));
        searchbox.sendKeys("MAC");

        //SVG x path -//*[name()='svg']
        //Step 2 find all the SVG elements on page
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElements.get(4).click();



    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
  driver.close();
    }

}
