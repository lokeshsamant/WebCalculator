package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage {
		
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login")
	private WebElement loginButton;
	
	@FindBy(id = "usernameErr")
	private WebElement userNameError;
	
	@FindBy(id = "passwordErr")
	private WebElement passwordError;
	
	//In loginPage check all 3 fields are present
	public void isFieldPresent() throws InterruptedException {
		
		Assert.assertTrue(userName.isDisplayed());
		Assert.assertTrue(password.isDisplayed());
		Assert.assertTrue(loginButton.isDisplayed());
		System.out.println("TestCase1: All the 3 fields are present");
	}
	
	//One of two ​ fields cannot be empty
	public void loginWithoutCredentials() throws InterruptedException {
		
		loginButton.click();
		String userNameErr = userNameError.getText();
		Assert.assertEquals(userNameErr, "Invalid Username");
		Thread.sleep(3000);
		System.out.print("TestCase2 : "+userNameErr+" & ");
		userName.sendKeys("Test123");
		loginButton.click();
		Thread.sleep(3000);
		String passErr = passwordError.getText();
		Assert.assertEquals(passErr, "Invalid Password");
		System.out.println(passErr);
	}
	
	public void usernameValidation(String name) throws InterruptedException {
		
		int size = name.length();
		if(size<5)
		{
			System.out.println("TestCase3: User Name size is less than 5 characters ");
		}
		else if (size>20)
		{
			System.out.println("TestCase3: User Name size is more than 20 characters ");
		}
		else if (name.matches("[A-Za-z0-9]+"))
		{
			System.out.println("TestCase3: Valid username");
			userName.sendKeys(name);
			 loginButton.click(); 
			 Thread.sleep(1000);
			 Assert.assertEquals(userNameError.isDisplayed(), false);
			Thread.sleep(1000);
			
		}
		else 
		{
			System.out.println("TestCase3: User Name contains special characters");
		}
	}
	
	public void passwordValidation(String password) throws InterruptedException {
		
		int size = password.length();
		if(size<6)
		{
			System.out.println("TestCase4: Password size is less than 6 characters ");
		}
		else if (size>20)
		{
			System.out.println("TestCase4: Password size is more than 20 characters ");
		}
		else if (password.matches("[A-Za-z0-9]+"))
		{
			if(password.matches("[A-Za-z]+") && password.matches("[0-9]+"))
			{
			System.out.println("TestCase4: Valid Password");
			userName.sendKeys(password);
			loginButton.click(); 
			 Thread.sleep(1000);
			 Assert.assertEquals(passwordError.isDisplayed(), false);
			Thread.sleep(1000);
			}
			else
			{
			System.out.println("TestCase4: Password must contain number and characters");
			}
		}
		else 
		{
			System.out.println("TestCase4: Password contains special characters");
		}
	}
	
	// This method uses Admin User to login to the Application
	 public void loginToApp() throws InterruptedException {
	 
	 userName.sendKeys("Admin1"); 
	 password.sendKeys("admin123");
	 loginButton.click(); 
	 Thread.sleep(3000);
	 Assert.assertEquals(loginButton.isDisplayed(), false);
	 System.out.println("TestCase5: Able to login sucessfully");
	 }
	




}