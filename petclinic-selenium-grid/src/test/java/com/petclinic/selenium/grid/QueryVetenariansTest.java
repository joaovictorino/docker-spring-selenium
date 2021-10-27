package com.petclinic.selenium.grid;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class QueryVetenariansTest {
    @Test
    public void testShouldQueryVetenarians() throws Exception {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors"); 
        WebDriver browser = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        browser.navigate().to("http://172.17.0.1:8080");
        browser.findElement(By.xpath("//*[@id='main-navbar']/ul/li[3]/a")).click();
        List<WebElement> elements = browser.findElements(By.xpath("//*[@id='vets']/thead/tr/th[2]"));
        assertTrue(elements.size() > 0);
        assertTrue(elements.get(0).getText().equals("Specialties"));
        browser.quit();
    }
}
