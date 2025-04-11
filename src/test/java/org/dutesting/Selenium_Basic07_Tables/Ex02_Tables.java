package org.dutesting.Selenium_Basic07_Tables;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;
public class Ex02_Tables {
    @Test
    @Description("Verify and validate tables")
    public void handelsTabels() {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable1.html");

        WebElement table = driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));

        //roe and columns
        List<WebElement> row_table = table.findElements(By.tagName("tr"));

        for (int i = 0; i < row_table.size(); i++) {
            List<WebElement> col = row_table.get(i).findElements(By.tagName("td"));
            for (WebElement c : col) {
                System.out.print(c.getText() + " | ");
            }
            System.out.println();
        }
        driver.close();
    }
}
