package com.pages;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.math.*; 


public class Calculator {
		
	public WebDriver driver;
	public Calculator(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(text(),'+')]")
	private WebElement addButton;
	
	@FindBy(xpath = "//button[contains(text(),'-')]")
	private WebElement subtractButton;
	
	@FindBy(xpath = "//button[contains(text(),'×')]")
	private WebElement multipleButton;
	
	@FindBy(xpath = "//button[contains(text(),'÷')]")
	private WebElement devideButton;
	
	@FindBy(xpath = "//button[contains(text(),'=')]")
	private WebElement equalButton;
	
	@FindBy(xpath = "//button[contains(text(),'CE')]")
	private WebElement clearButton;
	
	@FindBy(xpath = "//button[contains(text(),'AC')]")
	private WebElement allclearButton;
	
	@FindBy(xpath = "//button[contains(text(),'.')]")
	private WebElement decimalButton;
	
	@FindBy(xpath = "//div[@class='calculator__display']")
	private WebElement display;
		
	public void add(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		addButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		int sum1 = a + b;
		if(sum1 == Integer.parseInt(display.getText())) 
			System.out.println("TestCase6: addition of two integer number "+ Integer.parseInt(display.getText()) +" and "+ sum1); 
		else
			System.out.println("TestCase6 (Failed): addition of two integer number "+ Integer.parseInt(display.getText()) +" and "+ sum1);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
		
	}
	
	public void addDecimal(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		decimalButton.click();
		int c = a+2;
		driver.findElement(By.xpath("//button[contains(text(),'"+c+"')]")).click();
		addButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		String first = a+"."+c;
		double sum2 = Double.valueOf(first) + Double.valueOf(b);
		if(sum2 == Double.valueOf(display.getText())) 
			System.out.println("TestCase6: addition of two decimal number "+ Double.valueOf(display.getText()) +" and "+ sum2);
		else
			System.out.println("TestCase6 (Failed): addition of two decimal number "+ Double.valueOf(display.getText()) +" and "+ sum2);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
	public void addNegative(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		decimalButton.click();
		int c = a+2;
		driver.findElement(By.xpath("//button[contains(text(),'"+c+"')]")).click();
		addButton.click();
		subtractButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		String first = a+"."+c;
		String second = "-"+b;
		double sum3 = Double.valueOf(first) + Double.valueOf(second);
		if(sum3 == Double.valueOf(display.getText())) 
			System.out.println("TestCase6: subtract of two negative number "+ Double.valueOf(display.getText()) +" and "+ sum3);
		else
			System.out.println("TestCase6 (Failed): subtract of two negative number "+ Double.valueOf(display.getText()) +" and "+ sum3);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
	public void subtract(int a , int b , WebDriver driver) throws InterruptedException {
			
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		subtractButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		int sub1 = a - b;
		if(sub1 == Double.valueOf(display.getText()))
			System.out.println("TestCase7: subtract of two integer number "+ Double.valueOf(display.getText()) +" and "+ sub1);
		else
			System.out.println("TestCase7 (Failed): subtract of two integer number "+ Double.valueOf(display.getText()) +" and "+ sub1);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
	public void subtractDecimal(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		decimalButton.click();
		int c = a+2;
		driver.findElement(By.xpath("//button[contains(text(),'"+c+"')]")).click();
		subtractButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		String first = a+"."+c;
		double sub2 = Double.valueOf(first) - Double.valueOf(b);
		if(sub2 == Double.valueOf(display.getText())) 
			System.out.println("TestCase7: subtract of two decimal number "+ Double.valueOf(display.getText()) +" and "+ sub2);
		else
			System.out.println("TestCase7 (Failed): subtract of two decimal number "+ Double.valueOf(display.getText()) +" and "+ sub2);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
	public void subtractNegative(int a , int b , WebDriver driver) throws InterruptedException {
		
		subtractButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		decimalButton.click();
		int c = a+2;
		driver.findElement(By.xpath("//button[contains(text(),'"+c+"')]")).click();
		subtractButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		String first = "-"+a+"."+c;
		double sub3 = Double.valueOf(first) - Double.valueOf(b);
		if(sub3 == Double.valueOf(display.getText())) 
			System.out.println("TestCase7: subtract of two negative number "+ Double.valueOf(display.getText()) +" and "+ sub3);	
		else
			System.out.println("TestCase7 (Failed): subtract of two negative number "+ Double.valueOf(display.getText()) +" and "+ sub3);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
	public void divide(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		devideButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		double div1 = Double.valueOf(a) / Double.valueOf(b);
		if(div1 == Double.valueOf(display.getText()))
			System.out.println("TestCase8: divide of two integer number "+ Double.valueOf(display.getText()) +" and "+ div1);
		else
			System.out.println("TestCase8 (Failed): divide of two integer number "+ Double.valueOf(display.getText()) +" and "+ div1);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
		
	}
	
	public void divideDecimal(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		devideButton.click();
		decimalButton.click();
		int c = a+2;
		driver.findElement(By.xpath("//button[contains(text(),'"+c+"')]")).click();
		equalButton.click();
		String first = "0."+c;
		double div2 = Double.valueOf(b) / Double.valueOf(first);
		if(div2 == Double.valueOf(display.getText())) 
			System.out.println("TestCase8: divide of two decimal number "+ Double.valueOf(display.getText()) +" and "+ div2);
		else
			System.out.println("TestCase8 (Failed): divide of two decimal number "+ Double.valueOf(display.getText()) +" and "+ div2);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
	public void divideNegative(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		devideButton.click();
		subtractButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		decimalButton.click();
		int c = a+2;
		driver.findElement(By.xpath("//button[contains(text(),'"+c+"')]")).click();
		equalButton.click();
		String first = "-"+a+"."+c;
		double div3 = Double.valueOf(b) / Double.valueOf(first);
		if(div3 == Double.valueOf(display.getText())) 
			System.out.println("TestCase8: divide of two negative number "+ Double.valueOf(display.getText()) +" and "+ div3);
		else
			System.out.println("TestCase8 (Failed): divide of two negative number "+ Double.valueOf(display.getText()) +" and "+ div3);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
	public void divideExp(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		devideButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		double div3 = Double.valueOf(a) / Double.valueOf(b);	
		if(div3 == Double.valueOf(display.getText())) 
			System.out.println("TestCase9: divide by Zero "+ Double.valueOf(display.getText()) +" and "+ div3);
		else
			System.out.println("TestCase9 (Failed): divide by Zero "+ Double.valueOf(display.getText()) +" and "+ div3);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
	public void multiply(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		multipleButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		double mul1 = Double.valueOf(a) * Double.valueOf(b);
		if(mul1 == Double.valueOf(display.getText()))
			System.out.println("TestCase9: multiply of two integer number "+ Double.valueOf(display.getText()) +" and "+ mul1);
		else
			System.out.println("TestCase9 (Failed): multiply of two integer number "+ Double.valueOf(display.getText()) +" and "+ mul1);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
		
	}
	
	public void multiplyDecimal(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		decimalButton.click();
		int c = a+2;
		driver.findElement(By.xpath("//button[contains(text(),'"+c+"')]")).click();
		multipleButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		equalButton.click();
		String first = a+"."+c;
		double mul2 = Double.valueOf(first) * Double.valueOf(b);
		if(mul2 == Double.valueOf(display.getText())) 
			System.out.println("TestCase9: multiply of two decimal number "+ Double.valueOf(display.getText()) +" and "+ mul2);
		else
			System.out.println("TestCase9 (Failed): multiply of two decimal number "+ Double.valueOf(display.getText()) +" and "+ mul2);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
	public void multiplyNegative(int a , int b , WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),'"+b+"')]")).click();
		multipleButton.click();
		subtractButton.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+a+"')]")).click();
		decimalButton.click();
		int c = a+2;
		driver.findElement(By.xpath("//button[contains(text(),'"+c+"')]")).click();
		equalButton.click();
		String first = "-"+a+"."+c;
		double mul3 = Double.valueOf(first) * Double.valueOf(b);
		if(mul3 == Double.valueOf(display.getText())) 
			System.out.println("TestCase9: multiply of two negative number "+ Double.valueOf(display.getText()) +" and "+ mul3);
		else
			System.out.println("TestCase9 (Failed): multiply of two negative number "+ Double.valueOf(display.getText()) +" and "+ mul3);
		clearButton.click();
		allclearButton.click();
		Thread.sleep(3000);
	}
	
}