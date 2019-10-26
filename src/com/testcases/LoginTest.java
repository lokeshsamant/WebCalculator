package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Calculator;
import com.pages.LoginPage;

public class LoginTest {

	public WebDriver driver;
	LoginPage login = new LoginPage(driver);
	Calculator cal = new Calculator(driver);

	
	 @BeforeTest 
	 public void setProperty() throws InterruptedException {
		 
		 	System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
	 }
	 
	 @Test ( priority = 0 )
	 public void lunchApp() throws InterruptedException {
			
		 driver.get("http://qa-1.s3-website-ap-southeast-1.amazonaws.com/");
		 Thread.sleep(3000);
	}
	 

	@Test ( priority = 1 )
	public void FieldPresent() throws InterruptedException {
		
		// The page consists of two fields - ​Username ​ and ​Password ​ , and a button ​Login 
		login=new LoginPage(driver);
		login.isFieldPresent();
		}
	
	@Test( priority = 2 )
	public void loginData() throws InterruptedException {
		
		//  The ​username/password ​ fields cannot be empty. 
		login=new LoginPage(driver);
		login.loginWithoutCredentials();
		driver.navigate().refresh();
		Thread.sleep(2000);
		}
	
	@Test( priority = 3 )
	public void userName() throws InterruptedException {
		
		//  The ​username ​ should be a minimum of 5 characters and maximum 20. It should not contain any special characters and is case insensitive 
		login=new LoginPage(driver);
		login.usernameValidation("Test@123");
		login.usernameValidation("Test");
		login.usernameValidation("T12345678901234567890");
		login.usernameValidation("Test1234567890123456");
		driver.navigate().refresh();
		Thread.sleep(2000);
		}
	
	@Test( priority = 4 )
	public void passWord() throws InterruptedException {
		
		//The ​password ​ should at least be 6 letters long, and must include both characters and numbers. No special characters are allowed. The password can be maximum 20 characters long.  
		login=new LoginPage(driver);
		login.passwordValidation("Test!123");
		login.passwordValidation("Test1");
		login.passwordValidation("T12345678901234567890");
		login.passwordValidation("Test1234567890123456");
		driver.navigate().refresh();
		Thread.sleep(2000);
		}
	
	@Test(priority = 5 )
	public void login() throws InterruptedException {

		//The ​Login ​ button would trigger username and password verification (just ensuring it satisfies criteria as mentioned in 4 and 5) and let you login if the verification is successful
		login=new LoginPage(driver);
		login.loginToApp();
		Thread.sleep(2000);
	}
	
	@Test ( priority = 6 )
	public void Add() throws InterruptedException {
		
		cal = new Calculator(driver);
		cal.add(1,3,driver);
		Thread.sleep(2000);
		cal.addDecimal(5,7,driver);
		Thread.sleep(2000);
		cal.addNegative(7,9,driver);
		Thread.sleep(2000);
		}
	
	@Test ( priority = 7 )
	public void Sub() throws InterruptedException {
		
		cal = new Calculator(driver);
		cal.subtract(1,3,driver);
		Thread.sleep(2000);
		cal.subtractDecimal(7,1,driver);
		Thread.sleep(2000);
		cal.subtractNegative(3,1,driver);
		Thread.sleep(2000);
		}
	
	@Test ( priority = 8 )
	public void Dev() throws InterruptedException {
		
		cal = new Calculator(driver);
		cal.divide(1,3,driver);
		Thread.sleep(2000);
		cal.divide(0,1,driver);
		Thread.sleep(2000);
		cal.divideDecimal(7,6,driver);
		Thread.sleep(2000);
		cal.divideNegative(7,2,driver);
		Thread.sleep(2000);
		cal.divideExp(1,0,driver);
		Thread.sleep(2000);
		}
	
	@Test ( priority = 9 )
	public void Multi() throws InterruptedException {
		
		cal = new Calculator(driver);
		cal.multiply(1,3,driver);
		Thread.sleep(2000);
		cal.multiplyDecimal(0,5,driver);
		Thread.sleep(2000);
		cal.multiplyNegative(7,6,driver);
		Thread.sleep(2000);
		}
	
	@AfterTest
	public void CloseApp() throws InterruptedException {
	
		driver.quit();
		}
	

}
