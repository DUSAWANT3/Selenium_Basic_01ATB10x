package org.dutesting.Selenium_BasicProject03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Pro12_RS_Assisment8 {

    @Test
    //GreenCart is E-commerce website
    public void assisment8() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //URL
        driver.manage().window().maximize();

        //Click on redio but
        driver.findElement(By.xpath("//input[@value=\"radio2\"]")).click();

        //In check box select 2 option and the same option select from dropdown
        String option = "option3";
        List<WebElement> checkBox = driver.findElements(By.xpath("//label/input[@type=\"checkbox\"]"));
        for(WebElement allOptions : checkBox){
            if(allOptions.getDomAttribute("value").equals(option)){
                         allOptions.click();
                System.out.println("selected Option"+ allOptions.getDomAttribute("value"));
            }
        }
    //Static dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"dropdown-class-example\"]"));
        Select select = new Select(dropdown);
        select.selectByValue(option);
        System.out.println(select.getFirstSelectedOption().getText());

     //Alert Box
     driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys(option);
     driver.findElement(By.id("alertbtn")).click();
     //Alert box open
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());//get alert test
        System.out.println(alert.getText().contains(option) + " Alert");
        alert.accept();

        //Suggession dropdown
        WebElement searchbox = driver.findElement(By.id("autocomplete"));
        searchbox.sendKeys("Ind");
        Thread.sleep(2000);
        WebElement selectIndia = driver.findElement(By.xpath("//div[@class=\"ui-menu-item-wrapper\"][text()='India']"));
        selectIndia.click();
        System.out.println(searchbox.getText());

        driver.quit();
    }
}

