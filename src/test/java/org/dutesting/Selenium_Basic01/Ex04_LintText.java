package org.dutesting.Selenium_Basic01;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex04_LintText {


    @Test
    @Description("click on llink Text")

    public void clickonLinktext() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

      // <a href="https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage"
        // class="text-link"
        // data-qa="bericafeqo">Start a free trial</a>

        //LinkText == Full text match

      /*  WebElement LinkText = driver.findElement(By.linkText("Start a free trial"));
        LinkText.click();

        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");
*/

        // PartialLinkText- Contains
        WebElement LinkText = driver.findElement(By.partialLinkText("Start a free"));
        LinkText.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");

        driver.close();
    }


}
