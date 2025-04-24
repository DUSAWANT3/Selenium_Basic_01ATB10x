package org.dutesting.Selenium_BasicProject03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Pro10_Ch01_ACME {

    @Test
    //GreenCart is E-commerce website
    public void assisment8() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.applitools.com/"); //URL
        driver.manage().window().maximize();

        //Enter the Username as Admin and Password as Password@123
        driver.findElement(By.id("username")).sendKeys("Admin");
        driver.findElement(By.id("password")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
        driver.findElement(By.id("log-in")).click();

        //Verify that you are on the app.html page afterward.
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.applitools.com/app.html");

        //Calculate the total amount spent this month.
        List<WebElement> tableAmount = driver.findElements(By.xpath("//table//tbody/tr/td[5]"));

        double totalSpendAmount = 0;
        for (WebElement amount : tableAmount) {
            String rawAmount = amount.getText(); // e.g., "+ 952.23 USD"
            System.out.println(rawAmount);

            // Remove "USD", trim, and handle +/-
            String numericPart = rawAmount.replace("USD", "").trim()
                    .replace(",", "")
                    .replaceAll("\\s+", "");;
            //String numericPart = rawAmount.split(" ")[0].trim();

            double spendAmount = Double.parseDouble(numericPart); // This will work even for negative values

            // Only consider negative amounts as "spent"
            if (spendAmount < 0) {
                totalSpendAmount += Math.abs(spendAmount); // Add as positive value
                //Math.abs() is a Java method that gives you the absolute value.
                //It removes the minus sign, so: Math.abs(-320.0) becomes 320.0
            }
        }
        System.out.println("Total amount spent this month = " + totalSpendAmount + " USD");

        driver.quit();
    }
}
