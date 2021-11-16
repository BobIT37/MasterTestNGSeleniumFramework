package com.masterframework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.masterframework.pom.base.BaseTest;
import com.masterframework.pom.pages.CartPage;
import com.masterframework.pom.pages.CheckoutPage;
import com.masterframework.pom.pages.HomePage;
import com.masterframework.pom.pages.StorePage;

public class MyFirstTestCase extends BaseTest{
	
	/* 
	 * Error: “chromedriver” cannot be opened because the developer cannot be verified. Unable to launch the chrome browser
	 * Navigate to chromedriver folder where you set
	 * Execute in terminal following command after navigate to folder
	 * xattr -d com.apple.quarantine chromedriver 
	 * 
	 * or
	 * 
	 * chmod +x chromedriver
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
		//driver.get("https://askomdch.com");
		
		StorePage storePage = new HomePage(driver).
				load().
				navigateToStoreUsingMenu().
				search("Blue");
//		HomePage homePage = new HomePage(driver);
//		StorePage storePage = homePage.navigateToStoreUsingMenu();
//		TimeUnit.SECONDS.sleep(3);
//		storePage.search("Blue");
//		TimeUnit.SECONDS.sleep(3);
		Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
		storePage.clickAddToCartBtn("Blue Shoes");
		TimeUnit.SECONDS.sleep(5);
		CartPage cartPage = storePage.clickViewCart();
		Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
		CheckoutPage checkoutPage = cartPage.checkout();
		checkoutPage.
					enterFirstName("demoTest").
					enterLasttName("user").
					enterAddressLineOne("824 Belmont Ave").
					enterCity("North Haledon").
					enterPostCode("94188").
					enterEmail("bobtery123@gmail.com").			
					placeOrder();
		TimeUnit.SECONDS.sleep(5);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
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
		
		//driver.get("https://askomdch.com");
		
		StorePage storePage = new HomePage(driver).
				load().
				navigateToStoreUsingMenu().
				search("Blue");
		
		Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
		
		storePage.clickAddToCartBtn("Blue Shoes");
		TimeUnit.SECONDS.sleep(5);
		CartPage cartPage = storePage.clickViewCart();
		Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
		
		CheckoutPage checkoutPage = cartPage.checkout();
		checkoutPage.clickHereToLoginLink();
		TimeUnit.SECONDS.sleep(3);
		
		checkoutPage.
		            login("demousertest", "Test$123").
					enterFirstName("demoTest").
					enterLasttName("user").
					enterAddressLineOne("824 Belmont Ave").
					enterCity("North Haledon").
					enterPostCode("94188").
					enterEmail("bobtery123@gmail.com").			
					placeOrder();
		TimeUnit.SECONDS.sleep(5);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
	}

}
