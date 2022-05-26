package com.petclinic.selenium.grid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@TestInstance(Lifecycle.PER_CLASS)
public class CreateOnwerTest {
  private WebDriver driver;
  JavascriptExecutor js;

  @BeforeAll
  public void setUp() throws MalformedURLException {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--ignore-certificate-errors"); 
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
    js = (JavascriptExecutor) driver;
  }

  @AfterAll
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void testCreateOnwer() {
    // ip address of host running docker
    driver.navigate().to("http://172.17.0.1:8080");
    driver.findElement(By.cssSelector("li:nth-child(2) span:nth-child(2)")).click();
    driver.findElement(By.linkText("Add Owner")).click();
    driver.findElement(By.id("firstName")).click();
    driver.findElement(By.id("firstName")).sendKeys("João Henrique");
    driver.findElement(By.id("lastName")).sendKeys("From Grid");
    driver.findElement(By.id("address")).sendKeys("Avenida Paulista, 15000");
    driver.findElement(By.id("city")).sendKeys("São Paulo");
    driver.findElement(By.id("telephone")).sendKeys("999999999");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("Thor");
    driver.findElement(By.id("birthDate")).sendKeys("2016-05-08");
    {
      WebElement dropdown = driver.findElement(By.id("type"));
      dropdown.findElement(By.xpath("//option[. = 'dog']")).click();
    }
    {
      WebElement element = driver.findElement(By.id("type"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("type"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.id("type"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("type")).click();
    driver.findElement(By.cssSelector(".btn")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//dd[contains(.,\'Thor\')]"));
      assertTrue(elements.size() > 0);
    }
  }
}
