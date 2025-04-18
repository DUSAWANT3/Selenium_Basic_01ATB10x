package org.dutesting.Selenium_Basic08_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class Ex03_Drag_Drop {
    @Test

    public void ActionClass() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/droppable"); //URL
        driver.manage().window().maximize();

        WebElement from = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement to  = driver.findElement(By.id("droppable"));
        WebElement msg = driver.findElement(By.xpath("//div[@id=\"droppable\"]/p"));

        System.out.println(msg.getText());
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(from, to).build().perform();

        System.out.println(msg.getText());
    }
}
