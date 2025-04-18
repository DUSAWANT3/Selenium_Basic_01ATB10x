package org.dutesting.Selenium_Basic08_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex06_fileUpload2 {

    @Test

    public void fileUpload() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement choiseFile = driver.findElement(By.id("singleFileInput"));
        choiseFile.sendKeys("C:\\Users\\durge\\OneDrive\\Desktop\\SeleniumData");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();


        //verify massage
        WebElement msg = driver.findElement(By.id("singleFileStatus"));
        System.out.println(msg.getText());

        driver.quit();
    }
}


