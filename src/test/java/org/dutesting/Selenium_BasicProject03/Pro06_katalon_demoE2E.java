package org.dutesting.Selenium_BasicProject03;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Pro06_katalon_demoE2E {
    //Open the URL - https://katalon-demo-cura.herokuapp.com/
    //Enter the username and password
    //Verify that the current URL changes to https://katalon-demo-cura.herokuapp.com/#appointment
    @Test
    @Description("Verify that the current URL changes to")

    public void testVerifyKatalonDemo() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        // driver.manage().deleteAllCookies(); //To Delete all the cookies

        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

        //Click on make appointment
        WebElement MakeAppointment = driver.findElement(By.id("btn-make-appointment"));
        MakeAppointment.click();

        //Enter username and Password
        WebElement UserName = driver.findElement(By.id("txt-username"));
        UserName.sendKeys("John Doe");

        WebElement Password = driver.findElement(By.id("txt-password"));
        Password.sendKeys("ThisIsNotAPassword");

        //click on Login button
        WebElement LoginBut = driver.findElement(By.id("btn-login"));
        LoginBut.click();

        //Verify that the current URL changes to https://katalon-demo-cura.herokuapp.com/#appointment
        System.out.println(driver.getCurrentUrl());
       // Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

        //on Katalon -Make Appointment page fill all information
        //From dropdown select the Facility
        WebElement FacilityDropdown = driver.findElement(By.xpath("//select[@id=\"combo_facility\"]"));
        Select select = new Select(FacilityDropdown);

        select.selectByIndex(2); //Seoul CURA Healthcare Center
        //Verify selected value
        String selectedFacility = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedFacility,"Seoul CURA Healthcare Center","Incorrect Facility selected!");

    //Click on checkbox "Apply for hospital readmission"
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
       int a  = 3;
     //click on rediobutton -Healthcare Program -None
        WebElement HealthcareProgram = driver.findElement(By.xpath("//*[@class=\"radio-inline\"][3]"));
       HealthcareProgram.click();
        System.out.println(HealthcareProgram.getText());
        Assert.assertEquals(HealthcareProgram.getText(),"None");

    //Enter the visit date 07/04/2025
       driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys("07/04/2025");

    //Enter Comment
        WebElement comment = driver.findElement(By.xpath("//*[@id=\"txt_comment\"]"));
        comment.sendKeys("Booking Appointment on 07/04/2025");

     //click on book  Appointment
     driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

     Thread.sleep(4000);
        //Verify the Appointment Confirmation
        //*[@class="col-xs-offset-2 col-xs-8"]/div[@class="col-xs-4"]
        List<WebElement> labels = driver.findElements(By.xpath("//*[@class='col-xs-offset-2 col-xs-8']/div[@class='col-xs-4']"));
        List<WebElement> values = driver.findElements(By.xpath("//*[@class='col-xs-offset-2 col-xs-8']/div[@class='col-xs-8']"));

        for (int i = 0; i < labels.size(); i++) {
            String labelText = labels.get(i).getText();
            String valueText = values.get(i).getText();

            System.out.println(labelText + ": " + valueText);
        }

        // 11. Click on close menu and select "logout" from dropdown
        WebElement toggle_btn = driver.findElement(By.xpath("//a[@id = \"menu-toggle\"]"));
        toggle_btn.click();
        WebElement logout = driver.findElement(By.xpath("//a[@ href = 'authenticate.php?logout']"));
        logout.click();


       driver.quit();
    }
}
