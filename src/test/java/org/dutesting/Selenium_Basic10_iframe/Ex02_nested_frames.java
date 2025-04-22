package org.dutesting.Selenium_Basic10_iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex02_nested_frames {

    @Test
    public void iframe() {
//An DDT (inline frame) is an HTML document embedded inside another HTML document.
        //•	You’re seeing content from another webpage inside your current page
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/nested_frames");

        //WebElement mainFrame = driver.findElement(By.xpath("//frame[@name=\"frame-top\"]"));
        //driver.switchTo().frame(mainFrame);
         driver.switchTo().frame("frame-top");

        //WebElement midalFrame = driver.findElement(By.xpath("//frame[@name=\"frame-middle\"]"));
       // driver.switchTo().frame(midalFrame);
        driver.switchTo().frame("frame-middle");

       WebElement midalframename = driver.findElement(By.xpath("//body/div[@id=\"content\"]"));
        System.out.println(midalframename.getText());

        driver.switchTo().defaultContent();

        driver.quit();
    }
}

