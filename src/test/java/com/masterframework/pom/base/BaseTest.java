package com.masterframework.pom.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.masterframework.pom.factory.DriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void startDriver() {
		driver = new DriverManager().initializeDriver();
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

}
