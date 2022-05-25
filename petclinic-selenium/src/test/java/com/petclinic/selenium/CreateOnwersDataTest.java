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
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

@TestInstance(Lifecycle.PER_CLASS)
public class CreateOnwersDataTest {
  private WebDriver driver;
  JavascriptExecutor js;

  @BeforeAll
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
  }

  @AfterAll
  public void tearDown() {
    driver.quit();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/data/owners.csv")
  public void testCreateOnwer(String name, String lastName, String address, String city, String phone, String petName, String birthdate, String petType) {
    driver.get("http://localhost:8080/");
    driver.manage().window().setSize(new Dimension(1365, 767));
    driver.findElement(By.cssSelector("li:nth-child(2) span:nth-child(2)")).click();
    driver.findElement(By.linkText("Add Owner")).click();
    driver.findElement(By.id("firstName")).click();
    driver.findElement(By.id("firstName")).sendKeys(name);
    driver.findElement(By.id("lastName")).sendKeys(lastName);
    driver.findElement(By.id("address")).sendKeys(address);
    driver.findElement(By.id("city")).sendKeys(city);
    driver.findElement(By.id("telephone")).sendKeys(phone);
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys(petName);
    driver.findElement(By.id("birthDate")).sendKeys(birthdate);
    {
      WebElement dropdown = driver.findElement(By.id("type"));
      dropdown.findElement(By.xpath(String.format("//option[. = '%s']", petType))).click();
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
      List<WebElement> elements = driver.findElements(By.xpath(String.format("//dd[contains(.,\'%s\')]", petName)));
      assertTrue(elements.size() > 0);
    }
  }
}
