package com.masterframework.pom.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public WebDriver initializeDriver() {
		WebDriver driver;
		String browser = System.getProperty("browser");
		switch(browser) {
			case "Chrome":
				WebDriverManager.chromedriver().cachePath("drivers").setup();
				driver = new ChromeDriver();
				break;
			case "Firefox":
				WebDriverManager.firefoxdriver().cachePath("drivers").setup();
				driver = new FirefoxDriver();
				break;
			default:
				throw new IllegalStateException("Invalid browser name "+ browser);
		}
		
		//WebDriverManager.firefoxdriver().cachePath("drivers").setup();
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //selenium 4 uses Duration...
		return driver;
	}

}
