package org.dutesting.Selenium_Basic09_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Ex02_Windows {
    @Test
    public void windowsHandels(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/browser-windows");

        String parrantWindow = driver.getWindowHandle();//to save the current window ID

        //driver.findElement(By.id("tabButton")).click();  //open new tab
        driver.findElement(By.id("windowButton")).click(); //Open new child window

        Set<String> allWindows = driver.getWindowHandles();

        for(String handle : allWindows){
            if(!handle.equals(parrantWindow)){
                driver.switchTo().window(handle);
                System.out.println(driver.findElement(By.id("sampleHeading")).getText());
                System.out.println("Pass");
                //driver.close();
            }
        }
        driver.switchTo().window(parrantWindow);
    }
}
