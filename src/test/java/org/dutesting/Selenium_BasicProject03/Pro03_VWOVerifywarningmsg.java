package org.dutesting.Selenium_BasicProject03;

import com.beust.ah.A;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Pro03_VWOVerifywarningmsg {

    //login to VWO
    //click on 'Start a free trial' -link text /partial link text
    //give invalid id
    //verify warning msg when ckick on ok

    @Test
    @Description("Verify Worning Massage")
    public void verifyWarningMsg() throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        WebElement LinkText = driver.findElement(By.linkText("Start a free trial"));
        LinkText.click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        //enter invalid ID
        WebElement BusinessEmail = driver.findElement(By.id("page-v1-step1-email"));
        BusinessEmail.sendKeys("ABC.com");

        //Click on check Box
        WebElement CheckBox = driver.findElement(By.name("gdpr_consent_checkbox"));
        CheckBox.click();

        //click on but
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();

        Thread.sleep(2000);
        //Verify error massage

        WebElement warningMsg = driver.findElement(By.className("invalid-reason"));
        warningMsg.getText();

        System.out.println(warningMsg.getText());
        Assert.assertEquals(warningMsg.getText(),"The email address you entered is incorrect.");

        driver.close();

    }
}
