package com.masterframework.pom.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.masterframework.pom.factory.DriverManager;

public class BaseTest {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	private void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	
	protected WebDriver getDriver(){
        return this.driver.get();
    }
	
	@Parameters("browser")
	@BeforeMethod
	public void startDriver(@Optional String browser) {
		//browser = System.getProperty("browser", browser);
		if(browser == null) browser = "CHROME";
		setDriver(new DriverManager().initializeDriver(browser));
		System.out.println("current thread"+ Thread.currentThread().getId()+ " , "+ "driver information: "+ getDriver());
	}
	
	@AfterMethod
	public void quitDriver() {
		System.out.println("current thread"+ Thread.currentThread().getId()+ " , "+ "driver information: "+ getDriver());
		getDriver().quit();
	}

}
