package com.petclinic.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QueryVetenariansTest {
    @Test
    public void testShouldQueryVetenarians() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080");
        browser.findElement(By.xpath("//*[@id='main-navbar']/ul/li[3]/a")).click();
        List<WebElement> elements = browser.findElements(By.xpath("//*[@id='vets']/thead/tr/th[2]"));
        assertTrue(elements.size() > 0);
        assertTrue(elements.get(0).getText().equals("Specialties"));
        browser.quit();
    }
}
