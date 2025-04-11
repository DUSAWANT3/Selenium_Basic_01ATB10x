package org.dutesting.Selenium_Basic07_Tables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.SortedMap;
import java.util.concurrent.ForkJoinPool;

public class Ex01_Table_Static {

    @Test
    @Description("Verify and validate tables")
    public void handelsTabels() {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testautomationcentral.com/demo/table_interaction.html");

        //xpath - //table[@class="min-w-full bg-white"]/tbody/tr[1]/td[2]  --Cell row & coloums
        String FirstPart = "//table[@class=\"min-w-full bg-white\"]/tbody/tr[";
        String SecondPart = "]/td[";
        String ThiredPart = "]";

        //print row size
        int row = driver.findElements(By.xpath("//table[@class=\"min-w-full bg-white\"]/tbody/tr")).size();
        System.out.println("Row size = " + row);

        //print row size
        List<WebElement> row1 = driver.findElements(By.xpath("//table[@class=\"min-w-full bg-white\"]/tbody/tr"));
        System.out.println("Row Size = " + row1.size());

        //print Columns size
        List<WebElement> Col = driver.findElements(By.xpath("//table[@class=\"min-w-full bg-white\"]/tbody/tr[1]/td"));
        System.out.println("Columns Size = " + Col.size());
        int i = 0;
        int j = 0;


        //Print all the table data
        for (i = 1; i <= row1.size(); i++) { //find all rows
            for (j = 1; j <= Col.size(); j++) { //in first row mow to all columns
                String DynamicPath = FirstPart + i + SecondPart + j + ThiredPart;
                //System.out.println(DynamicPath);

                String Data = driver.findElement(By.xpath(DynamicPath)).getText();
                System.out.print(Data + "  ");

                if (Data.contains("Mike Johnson")) {
                    String agepath = DynamicPath + "/following-sibling::td[1]";
                    String age = driver.findElement(By.xpath(agepath)).getText();
                    System.out.println("Mike Johnson age is = "+ age);

                    Assert.assertEquals(age,"35","Not found correct data!");
                    Assert.assertTrue(age.contains("35"), "Not found correct data!");
                }
            }
            System.out.println();
        }


        // Print all the table data
        for (i = 1; i <= row1.size(); i++) { //find all rows
            List<WebElement> Col1 = driver.findElements(By.xpath("//table[@class=\"min-w-full bg-white\"]/tbody/tr[" + i + "]/td"));
            for (j = 1; j <= Col1.size(); j++) { //in first row mow to all columns
                WebElement cell = driver.findElement(By.xpath("//table[@class=\"min-w-full bg-white\"]/tbody/tr[" + i + "]/td[" + j + "]"));
                System.out.print(cell.getText() + " ");
            }
            System.out.println();
        }


        driver.close();
    }
}
