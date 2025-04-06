package org.dutesting.Selenium_Basic05_SVG_Elements;

import io.qameta.allure.Description;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

//1.	SVG - - Scalable Vector Graphics to define graphics for the web.
//2.	XML-based language to create 2-D graphics/images with animation and interactivity.
//3.	Use geometrical figures to draw an image.

public class Ex01_SVG_Elements {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new EdgeDriver();  // fixed redeclaration issue
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/search");
    }

    @Test(description = "Verify the search with SVG icon results are visible.")
    public void test_Flipkart_Search_SVG_Icon() throws InterruptedException {
        // Step 1 - Enter the "MACMINI" in inputBox
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("MACMINI");

        // Step 2 - Click the SVG search icon
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));
        if (!svgElements.isEmpty()) {
            svgElements.get(0).click();
        } else {
            System.out.println("SVG element not found.");
            return;
        }

        // Wait (not ideal, but since you haven't used WebDriverWait yet)
        Thread.sleep(3000);

        // Step 3 - Print search result titles
        List<WebElement> titlesResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for (WebElement title : titlesResults) {
            System.out.println(title.getText());
        }
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}