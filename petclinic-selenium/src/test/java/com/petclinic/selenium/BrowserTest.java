package com.petclinic.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserTest {
    @Test
    public void shouldOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); 
        options.addArguments("--disable-infobars"); 
        options.addArguments("--disable-extensions");
        WebDriver browser = new ChromeDriver(options);
        browser.navigate().to("http://localhost:8080");
    }
}
