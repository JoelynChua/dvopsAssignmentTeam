package com.sddevops.DVOPSAssignment.eclipse;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTestReview {
  //declare Selenium WebDriver
  //private WebDriver webDriver;		
  
  @Test
  public void LoginInsertReview() {
	  
	  WebDriver wd = new ChromeDriver();
	  //Load website as a new page
	  wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  wd.navigate().to("http://localhost:8090/DVOPSAssignment");
	  WebDriverWait wait = new WebDriverWait(wd, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));   
	  
	  wd.findElement(By.id("login")).click();
	  
	  //Login Page
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));   
	  wd.findElement(By.id("username")).sendKeys("test");
	  wd.findElement(By.id("form3Example4cg")).sendKeys("password");
	  wd.findElement(By.id("login")).click();
	  
	  //Profile Page after logging in
	  wd.findElement(By.id("ToReviews")).click();
	  
	  //In Reviews page find and click on "Add a Review"
	  wd.findElement(By.id("AddReview")).click();
	  
	  //Insert review for testing
	  wd.findElement(By.id("rating")).sendKeys("5");
	  wd.findElement(By.id("review")).sendKeys("test review");
	  wd.findElement(By.id("addnewreview")).click();
	  wd.navigate().to("http://localhost:8090/DVOPSAssignment/ReviewServlet/dashboard");
	  wd.quit();
  }
  /*@Test
  public void checkTitle() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/DVOPSAssignment/ReviewServlet/dashboard");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "Review Management Application");
	  
	  System.out.println("title: "+webDriver.getTitle());
	  
	  //Retrieve link using it's class name and click on it
	  webDriver.findElement(By.className("nav-link")).click();

	  //Assert the new title to check that the title contain Wikipedia and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("Add new review"));
	  System.out.println("new title: "+webDriver.getTitle());
  }*/
  
  
  
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  //webDriver wd = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  //webDriver.quit();			
  }

}