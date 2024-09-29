package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicValidation {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		//invoke the chrome browser
		driver = new ChromeDriver();
		
		//open facebook.com
		driver.get("https://www.facebook.com");
	}
	
	@AfterTest
	public void tearDown() {
		//close the browser after the test case is executed
		driver.quit();
	}
	
	@Test
	public void welcomeMessageValidation() {
		String expectedResult = "Facebook helps you connect and share with the people in your life.";
		String actualResult = driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();
		
		//to display in the test reports
		Reporter.log("Expected result = " + expectedResult);
		Reporter.log("Actual result = " + actualResult);
		
		//test comparison
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the wecome message,");
	}
	
	
	@Test
	public void pageTitleValidation() {
		String expectedResult = "Facebook – log in or sign up";
		String actualResult = driver.getTitle();
		
		//to display in the test reports
		Reporter.log("Expected result = " + expectedResult);
		Reporter.log("Actual result = " + actualResult);
		
		//test comparison
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");
	}
	
}
