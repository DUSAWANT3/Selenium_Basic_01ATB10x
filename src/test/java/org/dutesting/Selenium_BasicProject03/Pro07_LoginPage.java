package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Pro07_LoginPage {

    @Test
    @Description("Verify the login page")
    public void LoginPage(){
           //login with invalid id captcher the error message
        //Click on forgot password and captcher the password and use for loin
        //Verify when user login succesfull the user ID should be match in loginn msg

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        long time = 2;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

         String Username1 = "OKRAJ";
        //login with invalid id captcher the error message
        WebElement Username = driver.findElement(By.xpath("//*[@id=\"inputUsername\"]"));
        Username.sendKeys(Username1);

        WebElement PassWordloc = driver.findElement(By.xpath("//input[@name=\"inputPassword\"]"));
        PassWordloc.sendKeys("IncurrectPass");

        //click on check box
        WebElement IAgreeCheckBox = driver.findElement(By.xpath("//input[@id=\"chkboxTwo\"]"));
        IAgreeCheckBox.click();

        WebElement Singbut = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        Singbut.click();

       //captcher the error message
        WebElement errorMsg = driver.findElement(By.xpath("//p[@class=\"error\"]"));
        System.out.println(errorMsg.getText());

        Assert.assertEquals(errorMsg.getText(),"* Incorrect username or password","No error message element found");

        driver.close();
    }
}
