package org.dutesting.Selenium_Basic18_InvokingMultipalWindowsorTab;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Ex01_InvokingMultipalWindows {

    @Test
    public void greenKart() throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/"); //URL 1

//Invoking Multipal windows or Tabs
        //Work with 2 different URL in URL 1 fill  the name as Present course name in URL 2
        driver.switchTo().newWindow(WindowType.WINDOW); //TAB

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parrentWindowID = it.next();
        String childWindowID = it.next();

        driver.switchTo().window(childWindowID);
        driver.get("https://rahulshettyacademy.com/"); //URL 2

      WebElement course = driver.findElement(By.xpath("//a[contains(text(),'All-Access Membership-Complete')]"));
        String courseName = course.getText();

      driver.switchTo().window(parrentWindowID);
      WebElement WebElement = driver.findElement(By.xpath("//input[@name=\"name\"][@minlength=\"2\"]"));
        WebElement.sendKeys(courseName);

  //Captcher  WebElement Screenshot
        File src = WebElement.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("D:\\SeleniumSS\\screenshot1.png"));

        //FileUtils.copyFile(src, new File("Logo.png"));
         //Store SS in Selenium file

//Captcher Height and width of WebElement
        System.out.println(WebElement.getRect().getDimension().getHeight());
        System.out.println(WebElement.getRect().getDimension().getWidth());

      driver.quit();
    }

}