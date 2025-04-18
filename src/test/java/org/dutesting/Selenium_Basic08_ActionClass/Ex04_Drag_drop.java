package org.dutesting.Selenium_Basic08_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Ex04_Drag_drop {
    @Test
    public void ActionClass() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();

        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        // Move from source to center of target
        actions
                .clickAndHold(from)
                .moveToElement(to, to.getSize().width/2, to.getSize().height/2)
                .release()
                .build()
                .perform();

        Thread.sleep(2000);
        driver.quit();
    }
}
