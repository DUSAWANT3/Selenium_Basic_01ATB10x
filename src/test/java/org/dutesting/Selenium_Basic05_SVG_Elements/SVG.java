package org.dutesting.Selenium_Basic05_SVG_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SVG {

    @Test
    public void openBrowser() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/search");

        //Step 1 - Enter the "MACMINI" in inputBox.
        WebElement searchbox = driver.findElement(By.xpath("//*[@name=\"q\"]"));
        searchbox.sendKeys("MACMINI");

        //SVG x path -//*[name()='svg']
        //Step 2 find all the SVG elements on page
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElements.get(0).click();

         Thread.sleep(3000);
        List<WebElement> titlesResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for (WebElement title : titlesResults){
            System.out.println(title.getText());
        }
        driver.close();
    }



}
