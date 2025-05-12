package org.dutesting.Selenium_Project_RS;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Pro01_E2E_RS {
    ExtentReports extent;//Global  variable

    @BeforeTest
    public void config(){//generate HTML Repote
        //ExtentReports, ExtentSparkReporter
        String path  = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Result");
        reporter.config().setDocumentTitle("Test Result");

        extent =  new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","DURGEH");
    }

    @Test
    public void fileUpload() {
        extent.createTest("testName -Initial Demo");
        //extent.flush(); //use at the end of last test
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

        //Enter Username and password
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        //Click on User Popup will come
        driver.findElement(By.xpath("//label[@class=\"customradio\"][2]")).click();

        WebElement userBut = driver.findElement(By.id("okayBtn"));
        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userBut));

        userBut.click();
       //in Static Dropdown select Student option
        WebElement dropdown = driver.findElement(By.xpath("//select[@class=\"form-control\"]"));
        Select select = new Select(dropdown);
        select.selectByIndex(0);
        System.out.println(select.getFirstSelectedOption().getText());

        //Click on CheckBox
        driver.findElement(By.id("terms")).click();

        //Click on sign in but
        driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout ")));

        List<WebElement> addBut = driver.findElements(By.xpath("//button[@class=\"btn btn-info\"]"));
        for (WebElement but : addBut){
            but.click();
        }
        //click on checkout
        driver.findElement(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")).click();

        driver.quit();

        extent.flush();
    }
}