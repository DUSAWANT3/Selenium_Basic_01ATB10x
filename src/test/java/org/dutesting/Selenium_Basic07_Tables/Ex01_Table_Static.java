package org.dutesting.Selenium_Basic07_Tables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ex01_Table_Static {

    @Test
    @Description("Verify and validate tables")
    public void handelsTabels(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testautomationcentral.com/demo/table_interaction.html");

        //xpath - //table[@class="min-w-full bg-white"]/tbody/tr[1]/td[2]  -- row & coloums
        String FirstPart = "//table[@class=\"min-w-full bg-white\"]/tbody/tr[" ;
        String SecondPart = "]/td[" ;
        String ThiredPart = "]" ;

        //print row size
        int row = driver.findElements(By.xpath("//table[@class=\"min-w-full bg-white\"]/tbody/tr")).size();
        System.out.println("Row size = " +row);

        //print row size
        List<WebElement> row1 = driver.findElements(By.xpath("//table[@class=\"min-w-full bg-white\"]/tbody/tr"));
        System.out.println("Row Size = "+row1.size());

        driver.close();
    }
}
