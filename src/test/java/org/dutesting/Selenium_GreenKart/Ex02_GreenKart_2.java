package org.dutesting.Selenium_GreenKart;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Ex02_GreenKart_2 {
    @Test
    @Description("Verify and Add Items in Cart")
    //GreenCart is E-commerce website
    public void greenKart() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/"); //URL
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //Explicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Implicit wait appicable for every step

        //Here we can ot directly find out the particular Add to Cart button --shows 30 matches??
        //Firstly take all product name on page and then get indexes for that
        //Using this because in future some product add/delete no impact on script
        //We convert the String[] array to a List<String>
        //the List interface in Java provides useful methods like contains() — which is not available for plain arrays (String[]).

        // Items to be added in the cart
        String[] itemsNeeded = {"Brocolli", "Cucumber", "Beetroot", "Mango", "Water Melon"};

        addToCart(driver,itemsNeeded);
        //Click on kart button
        driver.findElement(By.xpath("//img[@alt=\"Cart\"]")).click();
        //Click on PROCEED TO CHECKOUT but
        driver.findElement(By.xpath("//div[@class=\"action-block\"]/button[text()='PROCEED TO CHECKOUT']")).click();

        //Enter a promo code
        WebElement promoCodeInputBox = driver.findElement(By.xpath("//input[@class=\"promoCode\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(promoCodeInputBox));

        promoCodeInputBox.sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//*[@class=\"promoBtn\"]")).click();
        //Captcher the Promo code msg
        WebElement promoCodeMsg = driver.findElement(By.xpath("//*[@class=\"promoInfo\"]"));

        wait.until(ExpectedConditions.visibilityOf(promoCodeMsg));

        System.out.println(promoCodeMsg.getText());
        Assert.assertEquals(promoCodeMsg.getText(),"Code applied ..!","Promo Code not applied..!");

        //Click on Place Order But
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        //Static dropdown select India
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/select"));

        Select select = new Select(dropdown);
        select.selectByValue("India");
        System.out.println(select.getFirstSelectedOption().getText());
        //Assert.assertEquals(select.getFirstSelectedOption(),"India","Incurrect Option selected");

        //Click on heckBox and Procid
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/button")).click();

        //Captchet the sucess massage -Classic timing issue — the success message appears only for 2–3 seconds and then the page auto-redirects,
          //Open DevTools (F12). -> Go to Sources tab.->Click the Pause icon (||) on top.->Then click Proceed.
        //This will pause JS execution → now inspect the DOM & find message XPath
       WebElement sucessMsg = driver.findElement(By.xpath("//div[@class=\"wrapperTwo\"]/span"));
        System.out.println(sucessMsg.getText());

        driver.quit();
    }
    public static void addToCart(WebDriver driver, String[] itemsNeeded) throws InterruptedException {
        int j = 0;
        // Capture all product names on the page
        List<WebElement> itemNames = driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));

        Thread.sleep(2000);

        for (int i = 0; i < itemNames.size(); i++) {
            String[] productName = itemNames.get(i).getText().split("-");
            // Format: Brocolli - 1 Kg => we split and trim to get only name
            String formatedName = productName[0].trim();

            List itemNeededList = Arrays.asList(itemsNeeded);//Convert String array into list

            if (itemNeededList.contains(formatedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
