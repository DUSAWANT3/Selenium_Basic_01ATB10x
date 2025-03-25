package org.dutesting.Selenium_Basic01;

import jdk.javadoc.internal.doclets.toolkit.util.NewAPIBuilder;
import org.junit.Test;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ex01_Selenium_Basic {

    @Test
    public void test_VerifyVWOLogin() {
        // Set path to chromedriver if not already in system PATH
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

       /* WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        System.out.println("Page title: " + driver.getTitle());
        driver.quit(); */

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
    }
}