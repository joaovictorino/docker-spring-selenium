package com.petclinic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

@TestInstance(Lifecycle.PER_CLASS)
public class CreateOnwerTest {
  private WebDriver driver;
  JavascriptExecutor js;

  @BeforeAll
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
  }

  @AfterAll
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void createOnwer() {
    driver.get("http://localhost:8080/");
    driver.manage().window().setSize(new Dimension(1365, 767));
    driver.findElement(By.cssSelector("li:nth-child(2) span:nth-child(2)")).click();
    driver.findElement(By.linkText("Add Owner")).click();
    driver.findElement(By.id("firstName")).click();
    driver.findElement(By.id("firstName")).sendKeys("João Henrique");
    driver.findElement(By.id("lastName")).sendKeys("Victorino da Silva");
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
