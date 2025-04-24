package org.dutesting.Selenium_Basic16_Broken_LinksCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Ex01_Broken_Link_Checker {
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

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links = " + links.size());

        for (WebElement link : links) {
            String url = link.getDomAttribute("href");

            if (url == null || url == isEmpty()) {
                System.out.println("⚠️ Skipping empty or null URL");
                continue;
            }
            try {
                HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println("❌ Broken link: " + url + " → " + responseCode);
                } else {
                    System.out.println("✅ Valid link: " + url + " → " + responseCode);
                }

            } catch (Exception e) {
                System.out.println("❗ Exception for link: " + url + " → " + e.getMessage());
            }
        }

        driver.quit();
    }

    private String isEmpty() {
        return null;
    }
}
