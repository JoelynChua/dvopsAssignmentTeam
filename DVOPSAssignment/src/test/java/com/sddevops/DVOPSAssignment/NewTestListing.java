package com.sddevops.DVOPSAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.WebElement;

//import org.testng.annotations.Parameters;

//import org.openqa.selenium.NoSuchElementException;

//import org.openqa.selenium.Keys;

public class NewTestListing {
	//declare Selenium WebDriver
	  private WebDriver webDriver;		
	  
	  @Test
	  public void checkLogin() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/DVOPSAssignment/login");
	  webDriver.findElement(By.name("loginInput_username")).sendKeys("Joelyn");
	  webDriver.findElement(By.name("loginInput_password")).sendKeys("123");
	  webDriver.findElement(By.id("loginBtn")).click();
	  
	  //Check
	  webDriver.navigate().to("http://localhost:8090/DVOPSAssignment/user");
	  
	  //Check if the profile reflects the correct username
	  WebElement currentUsername =  webDriver.findElement(By.xpath("/html/body/div/div/form[1]/div[2]/input"));
	  System.out.println("currentUsername: "+ currentUsername.getAttribute("value"));
	  Assert.assertEquals(currentUsername.getAttribute("value"), "Joelyn");
	  }
	  
	  
	  @Test
	  public void createListing() {
		  //Load website as a new page
		  webDriver.navigate().to("http://localhost:8090/DVOPSAssignment/createListing.jsp");
		  
		  webDriver.findElement(By.name("listingName")).sendKeys("testName");
		  webDriver.findElement(By.name("listingPrice")).sendKeys("10");
		  webDriver.findElement(By.name("listingCountry")).sendKeys("testCountry");
		  webDriver.findElement(By.name("listingRemarks")).sendKeys("testRemarks");
		  webDriver.findElement(By.name("listingImage")).sendKeys("testImage");
		  //webDriver.findElement(By.name("userId")).sendKeys("1000");
		  
		  //Retrieve link using it's class name and click on it
		  webDriver.findElement(By.name("createListing")).click();
		  		  
		  //Retrieve link using it's class name and click on it		 
		  webDriver.findElement(By.cssSelector("h1")).getText();
		  System.out.println("message:" + webDriver.findElement(By.cssSelector("h1")).getText());

		  //Assert to check that the success message is there
		  Assert.assertEquals(webDriver.findElement(By.cssSelector("h1")).getText(), "You have successfully created a listing!");
		  //System.out.println("createMsg: "+ msg.getAttribute("h1"));
	  }
	  
	  
	  @Test
	  public void details() {
		  //Load website as a new page
		  //homePage();
		  webDriver.navigate().to("http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings");
		  
		  //Get the detail button that corresponds to the listing
		  // +listingName+ - so that the listing name is not hardcoded, takes the parameter declared
		  webDriver.findElement(By.xpath("//html/body/div/div/div/div/div/h5[contains(@class,'card-title') and contains(text(),'testName')]/following-sibling::a[text()='Details']")).click();
		  
		  webDriver.findElement(By.xpath("/html/body/nav/div/a")).getText();
		  System.out.println("detail name:" + webDriver.findElement(By.xpath("/html/body/nav/div/a")).getText());

		  //Assert to check its the correct details page
		  Assert.assertEquals(webDriver.findElement(By.xpath("/html/body/nav/div/a")).getText(), "testName's Details");
		  
	  }
	  
	  
	  @Test
	  public void updateDeleteListing() {
		  //Load website as a new page
		  details();
		  webDriver.findElement(By.xpath("/html/body/nav/ul/li[2]/a")).click();
		  
		  webDriver.findElement(By.name("listingName")).sendKeys("updatedName");
//		  webDriver.findElement(By.name("listingPrice")).sendKeys("10");
//		  webDriver.findElement(By.name("listingCountry")).sendKeys("testCountry");
//		  webDriver.findElement(By.name("listingRemarks")).sendKeys("testRemarks");
//		  webDriver.findElement(By.name("listingImage")).sendKeys("testImage");
		  
		  //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  webDriver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();
		  
		  //Check if its updated
		  //homePage();
		  webDriver.navigate().to("http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings");
		  
		  webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //Check if the title contains the updated content
		  String actualTitle = webDriver.findElement(By.xpath("//html/body/div/div/div/div/div/h5[contains(@class,'card-title') and contains(text(),'updatedName')]")).getText();
		  System.out.println("actualTitle:" + actualTitle);
		  String expectedTitle = "updatedName";
		  Assert.assertTrue(actualTitle.contains(expectedTitle));
		  
		  //Delete 
		  webDriver.navigate().to("http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings");
		  
		  webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  webDriver.findElement(By.xpath("//html/body/div/div/div/div/div/h5[contains(@class,'card-title') and contains(text(),'testNameupdatedName')]/following-sibling::a[text()='Details']")).click();
		  
		//Look for delete button
		webDriver.findElement(By.xpath("/html/body/nav/ul/li[3]/a")).click();
		
		//Check if the deleted title is still there
		String deletedTitle = "testNameupdatedName";
		String findElement = webDriver.findElement(By.xpath("//html/body/div/div/div/div/div/h5[contains(@class,'card-title')]")).getText();
		Assert.assertFalse(findElement.contains(deletedTitle));
		
	  }
	  


	  

	 	  
	  
	  @BeforeTest
	  public void beforeTest() {
		  //Setting system properties of ChromeDriver
		  //to amend directory path base on your local file path
		  String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";

		  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		  //initialize FirefoxDriver at the start of test
		  webDriver = new ChromeDriver();  
	  }

	  @AfterTest
	  public void afterTest() {
		  //Quit the ChromeDriver and close all associated window at the end of test
		  webDriver.quit();			
	  }

	}