package org.dutesting.Selenium_Basic15_HTTP_Certification_SSL;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Ex01_HTTP_Certification_SSL {
    @Test
    public void HTTPCertification() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        Proxy proxy =new Proxy();
        proxy.setHttpProxy("ipadress:4344444"); //need to set
        options.setCapability("proxy", proxy);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://wrong.host.badssl.com/"); //URL
        driver.manage().window().maximize();

        System.out.println(driver.getCurrentUrl());
       driver.quit();
    }
}