package org.dutesting.Selenium_Basic16_Broken_LinksCheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Ex02_Broken_Link_Checker {
    @Test
    public void brokeLinksChecker() throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //URL
        driver.manage().window().maximize();

        //Logic:-   Use Selenium to get all <a> tags with href.
        // For each href:
        //•	Ignore if it's null or empty.
        //•	Use HttpURLConnection to send a request.
        //•	Get the response code.
        //•	If it's 400 or above, it's a broken link.
        //•	Developer tool >> Network tab >> Select XHR



    }
}
