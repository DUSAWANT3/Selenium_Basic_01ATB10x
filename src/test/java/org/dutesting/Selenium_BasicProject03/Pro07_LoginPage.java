package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Pro07_LoginPage {

    @Test
    @Description("Verify the login page dynamic password extraction")
    public void LoginPage(){
           //login with invalid id captcher the error message
        //Click on forgot password and captcher the password and use for loin
        //Verify when user login succesfull the user ID should be match in loginn msg
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();


        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        long time = 2;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

         String Username1 = "OKRAJ1";
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
        WebElement ResetlogBut = driver.findElement(By.xpath("//div[@class=\"forgot-pwd-btn-conainer\"]/button[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ResetlogBut)).click();

        WebElement passkey = driver.findElement(By.xpath("//p[@class=\"infoMsg\"]"));
        System.out.println(passkey.getText());

        //Captcher and store the password and all msg in Password
        //Please use temporary password 'rahulshettyacademy' to Login.

        String PasswordText = new String(passkey.getText());
        String[] passwordArray = PasswordText.split("'");
        //Ind 0-  Please use temporary password
        //Ind 1 - rahulshettyacademy' to Login.
        String[] password = passwordArray[1].split("'");
        //Ind[0]  --rahulshettyacademy
        //Ind[1] --  to Login.
        System.out.println(password[0]);

        //Click on Go to login but
        WebElement goToLogingBut = driver.findElement(By.xpath("//div[@class=\"forgot-pwd-btn-conainer\"]/button[1]"));
        goToLogingBut.click();

        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Username));

        //login with valid id & Pass
        Username.sendKeys(Username1);

        PassWordloc.sendKeys(password[0]);

        IAgreeCheckBox.click();

        Singbut.click();

     //Verify when user login succesfull the user ID should be match in login msg
      WebElement loggedmsg = driver.findElement(By.xpath("//div[@class=\"login-container\"]/h2"));

        String loggedMsgText = loggedmsg.getText();
        //Hello OKRAJ,

        Assert.assertEquals(loggedMsgText,"Hello " + Username1 +",");
        System.out.println("Hello " + Username1 +"," );

        driver.close();
    }
}
