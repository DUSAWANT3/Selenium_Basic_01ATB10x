package org.dutesting.Selenium_Basic07_Tables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Ex03_OrangeHRM_Table {

    @Test
    @Description("Validate the OrangeHRM table")
    public void OrangeHRM() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

         Thread.sleep(2000);
        //step 1 log in
        WebElement UserID = driver.findElement(By.xpath("//input[@placeholder='Username']"));
            UserID.click();
            UserID.sendKeys("Admin");

        WebElement Password = driver.findElement(By.xpath("//*[@name=\"password\"]"));
                 Password.click();
                 Password.sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

     //Step 2- click on PIM to open a table
        driver.findElement(By.xpath("//a[@class=\"oxd-main-menu-item active\"]")).click();

        WebElement table = driver.findElement(By.xpath("//div[@role=\"table\"]"));



driver.close();
    }
}
