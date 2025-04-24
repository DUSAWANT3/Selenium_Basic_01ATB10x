package org.dutesting.Selenium_Project_RS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Pro02_RS_Assisment7 {
    @Test
    //GreenCart is E-commerce website
    public void assisment7() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //URL
        driver.manage().window().maximize();

        //Task table count the   rows and coloums
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@name=\"courses\"]//tr"));
        System.out.println("Total count of row = " + tableRows.size());

        List<WebElement> tableColoums = driver.findElements(By.xpath("//table[@name=\"courses\"]//tr"))
                .get(2)
                .findElements(By.tagName("td"));
        System.out.println("Total count of row = " + tableColoums.size());

        //Print 2nd row values
        System.out.println(tableColoums.get(0).getText());
        System.out.println(tableColoums.get(1).getText());
        System.out.println(tableColoums.get(2).getText());

        driver.quit();
    }
}
