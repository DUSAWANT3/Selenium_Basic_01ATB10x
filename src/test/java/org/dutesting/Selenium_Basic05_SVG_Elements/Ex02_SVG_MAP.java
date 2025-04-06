package org.dutesting.Selenium_Basic05_SVG_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ex02_SVG_MAP {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
    }

    @Test(description = "Verify the Maharashtra is present in the map and click to Zoom")
    public void test_Flipkart_Search_SVG_Icon() throws InterruptedException {
        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for (WebElement state : states) {

            System.out.println(state.getDomAttribute("aria-label"));

            if (state.getDomAttribute("aria-label").contains("Maharashtra"))
            {
                state.click();
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
