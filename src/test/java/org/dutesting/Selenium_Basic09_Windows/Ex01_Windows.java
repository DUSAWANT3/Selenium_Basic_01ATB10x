package org.dutesting.Selenium_Basic09_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Set;

public class Ex01_Windows {
    @Test

    public void windows() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/browser-windows"); //URL
        driver.manage().window().maximize();

        String parrentWindow = driver.getWindowHandle(); ///Save / to get the window Id (Parrent tab)

        //Click on New tab but then open a new tab
        driver.findElement(By.id("tabButton")).click();

        Set<String> allWindows = driver.getWindowHandles();

        for(String handle : allWindows){
            if(!handle.equals(parrentWindow)){
                driver.switchTo().window(handle);
                System.out.println("Switched to new Window "+ driver.getTitle() );
                System.out.println(driver.findElement(By.id("sampleHeading")).getText());
                driver.close(); //Close Child window
            }
        }
    //Switch back to parrent Window
        driver.switchTo().window(parrentWindow);

        driver.close(); //closed parrant window
    }
}