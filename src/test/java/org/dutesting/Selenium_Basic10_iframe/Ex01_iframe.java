package org.dutesting.Selenium_Basic10_iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex01_iframe {

    @Test
    public void iframe() {
//An iframe (inline frame) is an HTML document embedded inside another HTML document.
        //•	You’re seeing content from another webpage inside your current page
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/frames");

        //move to or Switch to frame
        WebElement iframe = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe);

        //Perform action on frame
        System.out.println(driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText());

        //navigato to the main parrent page
        driver.switchTo().parentFrame();

        //navigate to the another frame - frame 2
        WebElement iframe2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(iframe2);

        //Perform action on frame
        System.out.println(driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText());

        //navigato to the main parrent page
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.xpath("//*[@class=\"text-center\"]")).getText());

        driver.quit();

    }
}