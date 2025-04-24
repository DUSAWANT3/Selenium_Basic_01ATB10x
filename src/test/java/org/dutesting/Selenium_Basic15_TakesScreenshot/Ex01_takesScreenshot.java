package org.dutesting.Selenium_Basic15_TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Ex01_takesScreenshot {
    @Test
    public void takesScreenshot() throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //URL
        driver.manage().window().maximize();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Take screenshot  Apache Commons IO's to save ss
        FileUtils.copyFile(src, new File("D:\\SeleniumSS\\screenshot1.png"));

        //alternative provided by Selenium itself to save ss
        FileHandler.copy(src, new File("D:\\SeleniumSS\\screenshot2.png"));

        driver.quit();
    }
}
