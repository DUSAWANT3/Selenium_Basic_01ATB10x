package org.dutesting.Selenium_Basic08_ActionClass;

import org.apache.commons.math3.optim.nonlinear.scalar.LineSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class Ex07_Scrolling_RS {
    @Test
    //GreenCart is E-commerce website
    public void scrolling() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //URL
        driver.manage().window().maximize();

     //Scroll the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        //Thread.sleep(3000);
    //Scroll the inner table
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

    //In table column 4 calculate the Amount and verify with Given Amount
        //tr =row  td =coloumn
        List<WebElement> amount = driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]//tr/td[4]"));
       int sum = 0;
        for(int i=0; i<amount.size();i++){
            sum = sum + Integer.parseInt(amount.get(i).getText());
        }
        System.out.println(sum);

        WebElement totalAmount = driver.findElement(By.xpath("//div[@class=\"totalAmount\"]"));
        System.out.println(totalAmount.getText()); //Total Amount Collected: 296
        int actualAmount = Integer.parseInt(totalAmount.getText().split(": ")[1].trim());
        System.out.println(actualAmount);

        Assert.assertEquals(actualAmount,sum,"Amount not match!");

        driver.quit();
    }
}