package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Pro04_OpenCartDemo {
    //Rejister on Opencart


    @Test
    @Description("Verify Open Cart Demo web Application")
    @Owner("Durgesh Sawant")
    public void OpenCartDemoVerify(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.opencart.com/index.php?route=common/home");

        //click on Register buttton


    }
}
