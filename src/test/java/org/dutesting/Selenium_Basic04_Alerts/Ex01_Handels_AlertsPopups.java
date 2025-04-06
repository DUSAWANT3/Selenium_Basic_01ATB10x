package org.dutesting.Selenium_Basic04_Alerts;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex01_Handels_AlertsPopups {

    //1.	Simple Alert (Information Alert) -- OK button
    //2.	Confirmation Alert --(OK / Cancel)
    //3.	Prompt Alert (Input Box Alert) --Accepts text input and provides OK/Cancel
    //4.	Authentication Alert (Browser Popup Login)-Pops up for username/password (like HTTP Basic Auth)

    @Test
    @Description("Handels Different types of Alerts")
    @Owner("DUSWANT")
    public void Handels_Alerts() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testautomationcentral.com/demo/alerts.html");

        //1.	Simple Alert (Information Alert) -- OK button
        //Click on Alert button
        driver.findElement(By.xpath("//button[@data-target=\"alert-tab\"]")).click();
        driver.findElement(By.xpath("//button[@onclick=\"showAlert()\"]")).click();
        //Alert display on screen

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());    //get alert test
        alert.accept();

        //Verify
        Thread.sleep(1000);
       WebElement AltMsg = driver.findElement(By.xpath("//*[@id=\"alert-message\"]"));
        Assert.assertEquals(AltMsg.getText(),"Alert displayed","Alert not Displayed");


        //2.	Confirmation Alert --(OK / Cancel)

        driver.findElement(By.xpath("//*[@data-target=\"confirm-tab\"]")).click();
        driver.findElement(By.xpath("//*[@onclick=\"showConfirm()\"]")).click();
        //Alert display on screen

         alert.accept(); //click ok
        //alert.dismiss(); // Click Cancel

        //Verify
        Thread.sleep(1000);
        WebElement AltMsg1 = driver.findElement(By.xpath("//*[@id=\"confirm-message\"]"));
        Assert.assertEquals(AltMsg1.getText(),"Confirmed","Alert not Displayed");

  //3.	Prompt Alert (Input Box Alert) --Accepts text input and provides OK/Cancel
        String AltEnterText = "Durgesh";

        driver.findElement(By.xpath("//*[@data-target=\"prompt-tab\"]")).click();
        driver.findElement(By.xpath("//*[@onclick=\"showPrompt()\"]")).click();
        //Alert display on screen
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());

        alert1.sendKeys(AltEnterText); //Enter text in alert box
        alert1.accept();                //Click on OK

        //Verify
        Thread.sleep(1000);
        WebElement AltMsg2 = driver.findElement(By.xpath("//*[@id=\"prompt-message\"]"));

        System.out.println(AltMsg2.getText());

        Assert.assertEquals(AltMsg2.getText(),"You entered: "+AltEnterText,"Alert not Displayed");

        driver.close();
    }
}
