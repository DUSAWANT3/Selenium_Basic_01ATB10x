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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Click on Forgot Password but
        WebElement ForgotPassBut = driver.findElement(By.xpath("//*[@class=\"forgot-pwd-container\"]/a"));
        ForgotPassBut.click();
        //Verify  the "Forgot password" page open
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement forgotPassPage= driver.findElement(By.xpath("//h2[text()='Forgot password']"));
        System.out.println(forgotPassPage.getText());
        //Assert.assertEquals(forgotPassPage.getText(),"Forgot password");

        //click on Reset login but
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("//div[@class=\"forgot-pwd-btn-conainer\"]/button[2]")).click();

        WebElement passkey = driver.findElement(By.xpath("//p[@class=\"infoMsg\"]"));
        System.out.println(passkey.getText());

        //Captcher and store the password and all msg in Password
        String Password = new String(passkey.getText());



        driver.close();
    }
}
