package com.masterframework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase {
	
	/* 
	 * Error: “chromedriver” cannot be opened because the developer cannot be verified. Unable to launch the chrome browser
	 * Navigate to chromedriver folder where you set
	 * Execute in terminal following command after navigate to folder
	 * xattr -d com.apple.quarantine chromedriver 
	 * 
	 */
	/**
	 * 
	 * github: section_1
	 * 
	 * @throws InterruptedException
	 * @author bobit
	 */
	@Test
	public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/bobit/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://askomdch.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
		driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
		driver.findElement(By.cssSelector("button[value='Search']")).click();
		TimeUnit.SECONDS.sleep(5);
		Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(), 
				"Search results: “Blue”");
		driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.cssSelector("a[title='View cart']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(), "Blue Shoes");
		driver.findElement(By.cssSelector(".checkout-button")).click();
		
		driver.findElement(By.id("billing_first_name")).sendKeys("demoTest");
		driver.findElement(By.id("billing_last_name")).sendKeys("user");
		driver.findElement(By.id("billing_address_1")).sendKeys("824 Belmont Ave");
		driver.findElement(By.id("billing_city")).sendKeys("North Haledon");
		driver.findElement(By.id("billing_postcode")).sendKeys("94188");
		driver.findElement(By.id("billing_email")).sendKeys("bobtery123@gmail.com");
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.id("place_order")).click();
		TimeUnit.SECONDS.sleep(3);
		Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(), "Thank you. Your order has been received.");
		driver.quit();
	}
	
	/**
	 * 
	 * github: section_2
	 * 
	 * @throws InterruptedException
	 * @author bobit
	 */
	@Test
	public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/bobit/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://askomdch.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
		driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
		driver.findElement(By.cssSelector("button[value='Search']")).click();
		TimeUnit.SECONDS.sleep(5);
		Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(), 
				"Search results: “Blue”");
		driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.cssSelector("a[title='View cart']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(), "Blue Shoes");
		driver.findElement(By.cssSelector(".checkout-button")).click();
		driver.findElement(By.className("showlogin")).click();
		TimeUnit.SECONDS.sleep(3);
		driver.findElement(By.id("username")).sendKeys("demousertest");
		driver.findElement(By.id("password")).sendKeys("Test$123");
		driver.findElement(By.name("login")).click();
//		driver.findElement(By.id("billing_first_name")).sendKeys("demoTest");
//		driver.findElement(By.id("billing_last_name")).sendKeys("user");
//		driver.findElement(By.id("billing_address_1")).sendKeys("824 Belmont Ave");
//		driver.findElement(By.id("billing_city")).sendKeys("North Haledon");
//		driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//		driver.findElement(By.id("billing_email")).clear();
//		driver.findElement(By.id("billing_email")).sendKeys("testdemo123@mailinator.com");
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.id("place_order")).click();
		TimeUnit.SECONDS.sleep(3);
		Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(), "Thank you. Your order has been received.");
		driver.quit();
	}

}
