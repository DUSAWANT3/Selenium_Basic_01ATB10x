package org.dutesting.Selenium_Basic14_links;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Ex01_Count_Links_onWebpage {

    @Test
    public void countLinks_Webpage() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Count the links on WebPage
        //Method 1- Direct - Find all the elements with tag name 'a'
        System.out.println("Links Present on webpage is = " + driver.findElements(By.tagName("a")).size());

//2. Count the links on footer
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));
        System.out.println("Links Present on webpage footer = " + footerLinks.size());

//3.  Count the links on footer only present in first column
        WebElement footerFirstColumn = driver.findElement(By.xpath("//div[@id=\"gf-BIG\"]//td[1]/ul"));
        List<WebElement> footerfirstColumnLinks = footerFirstColumn.findElements(By.tagName("a"));
        System.out.println("Links Present on webpage footer first Column = " + footerfirstColumnLinks.size());

//4. Click on each link and check the pages are opening
        //Challange- when we are clicking on link it will open on same page so we want it to be open in new tab
        //To open each link in a new tab, we’ll use:
        //Control + Click (for Windows)
        //Or use JavaScript to open in a new tab
        String mainTab = driver.getWindowHandle();

        for (int i = 1; i < footerfirstColumnLinks.size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footerfirstColumnLinks.get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }
        Set<String> allTabs = driver.getWindowHandles();

        for (String tab : allTabs) {
            driver.switchTo().window(tab);
            System.out.println("Title: " + driver.getTitle());

            if (!tab.equals(mainTab)) {
                driver.close(); // close newly opened tab
            }
        }
        driver.switchTo().window(mainTab); // back to original
        driver.quit();
    }
}