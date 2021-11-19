package com.masterframework.pom.base;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//page factory implementation
		//PageFactory.initElements(driver, this);
	}
	
	public void load(String endpoint) {
		driver.get("https://askomdch.com" + endpoint);
	}
	
   public void waitForOverlaysToDisappear(By overlay) {
	   List<WebElement> overlaysElements = driver.findElements(overlay);
		if(overlaysElements.size()>0) {
			wait.until(
					ExpectedConditions.invisibilityOfAllElements(overlaysElements));
		  System.out.println("Overlays found...!");	
		}else {
		  System.out.println("Overlays not found...!");
	 }
   }
   
//   public WebElement getElement(By element) {
//	   return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//   }

}
