package org.dutesting.Selenium_Basic16_Broken_LinksCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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

        List<WebElement> links = driver.findElements(By.xpath("//li[@class=\"gf-li\"]/a"));
        SoftAssert softassert = new SoftAssert();

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            int respCode = conn.getResponseCode();
            System.out.println(conn.getResponseCode());

            String brokenLink = new String(link.getText());

            // softassert.assertTrue(respCode > 400, "The link with text - " + brokenLink + " broken status code" + respCode);

            if (respCode > 400) {
                System.out.println("The link with text - " + brokenLink + " broken status code " + respCode);
            }
        }
        softassert.assertAll();
        driver.quit();
    }
}

