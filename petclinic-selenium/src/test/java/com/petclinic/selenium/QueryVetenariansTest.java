package com.petclinic.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class QueryVetenariansTest {
    @Test
    public void shouldQueryVetenarians() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); 
        options.addArguments("--disable-infobars"); 
        options.addArguments("--disable-extensions");
        WebDriver browser = new ChromeDriver(options);
        browser.navigate().to("http://localhost:8080");
        browser.findElement(By.xpath("//*[@id='main-navbar']/ul/li[3]/a")).click();
        List<WebElement> elements = browser.findElements(By.xpath("//*[@id='vets']/thead/tr/th[2]"));
        assertTrue(elements.size() > 0);
        assertTrue(elements.get(0).getText().equals("Specialties"));
        browser.quit();
    }
}
