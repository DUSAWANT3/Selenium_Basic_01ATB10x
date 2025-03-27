package org.dutesting.Selenium_Basic01;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Ex03_VWO_login {

    @Test
    @Description("To Verify the VWO login Funcanility")

    public void VerifyVWOLogin(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://app.vwo.com/#/login");

        driver.manage().window().maximize();

        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

       //get tital
        System.out.println("Titl == " + driver.getTitle());
     //   System.out.println(driver.getPageSource());

        //assertJ for validation
        assertThat(driver.getCurrentUrl());

        String name = "Durgesh";
        assertThat(name)
                .isNotNull()
                .startsWith("Dur")
                .endsWith("esh")
                .hasSize(7);

        driver.quit();

    }
}
