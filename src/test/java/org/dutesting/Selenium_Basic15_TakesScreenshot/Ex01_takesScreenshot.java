package org.dutesting.Selenium_Basic15_TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Ex01_takesScreenshot {
    @Test
    public void takesScreenshot() throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //URL
        driver.manage().window().maximize();
//Full window SS
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Take screenshot  Apache Commons IO's to save ss
        FileUtils.copyFile(src, new File("D:\\SeleniumSS\\screenshot1.png"));

        //alternative provided by Selenium itself to save ss
        FileHandler.copy(src, new File("D:\\SeleniumSS\\screenshot2.png"));

        //To save SS as per time stmp
        String  dest = ("D:\\SeleniumSS\\screenshot1");
        FileHandler.copy(src, new File(dest + System.currentTimeMillis() + ".png"));

        System.out.println(java.time.LocalDateTime.now());//2025-04-24T17:47:22.460166
        //file name not contain special cheracter so not file fond exception

        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"autocomplete\"]"));
 //Captcher  WebElement Screenshot
        File src1 = nameField.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src1, new File("D:\\SeleniumSS\\screenshot8.png"));

        FileUtils.copyFile(src1, new File("Logo1.png"));
        //Store SS in Selenium file

        driver.quit();
    }
}
