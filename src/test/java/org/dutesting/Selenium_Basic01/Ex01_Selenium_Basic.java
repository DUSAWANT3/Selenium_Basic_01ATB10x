package org.dutesting.Selenium_Basic01;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ex01_Selenium_Basic {

    @Test
    public void test_VerifyVWOLogin() {
        // Set path to geckodriver if not already in system PATH
        // System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");

        // Write the code which will execute and perform the UI interactions
        //FirefoxDriver driver = new FirefoxDriver();

       // WebDriver driver = new ChromeDriver();

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());

        // Optional: Close the browser after the test
        driver.quit();
    }
}