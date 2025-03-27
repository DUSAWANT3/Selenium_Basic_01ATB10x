package org.dutesting.Selenium_Basic01;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex03_VWO_login {

    @Test
    @Description("To Verify the VWO login Funcanility")

    public void VerifyVWOLogin(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://app.vwo.com/#/login");

        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");





        driver.quit();

    }
}
