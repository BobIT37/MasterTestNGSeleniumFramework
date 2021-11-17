package com.masterframework;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.masterframework.pom.base.BaseTest;
import com.masterframework.pom.objects.BillingAddress;
import com.masterframework.pom.objects.Products;
import com.masterframework.pom.objects.User;
import com.masterframework.pom.pages.CartPage;
import com.masterframework.pom.pages.CheckoutPage;
import com.masterframework.pom.pages.HomePage;
import com.masterframework.pom.pages.StorePage;
import com.masterframework.pom.utils.JacksonUtils;

public class MyFirstTestCase extends BaseTest{
	
	/**
	 * 
	 * Test: guestCheckoutUsingDirectBankTransfer
	 * 
	 * @throws InterruptedException
	 * @author bobit
	 * @throws IOException 
	 */
	@Test
	public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
		
		BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
	    Products product = new Products(1215);
	    
		StorePage storePage = new HomePage(driver).
				load().
				navigateToStoreUsingMenu().
				search("Blue");

		Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
		storePage.clickAddToCartBtn(product.getName());
		TimeUnit.SECONDS.sleep(5);
		CartPage cartPage = storePage.clickViewCart();
		Assert.assertEquals(cartPage.getProductName(), product.getName());
		CheckoutPage checkoutPage = cartPage.
				checkout().
				setBillingAddress(billingAddress).		
				placeOrder();
		TimeUnit.SECONDS.sleep(5);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
	}
	
	/**
	 * 
	 * Test: loginAndCheckoutUsingDirectBankTransfer
	 * 
	 * @throws InterruptedException
	 * @author bobit
	 * @throws IOException 
	 */
	@Test
	public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
		
		BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
	    Products product = new Products(1215);
	    User user = new User("demousertest", "Test$123");
		StorePage storePage = new HomePage(driver).
				load().
				navigateToStoreUsingMenu().
				search("Blue");
		
		Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
		
		storePage.clickAddToCartBtn(product.getName());
		TimeUnit.SECONDS.sleep(5);
		CartPage cartPage = storePage.clickViewCart();
		Assert.assertEquals(cartPage.getProductName(), product.getName());
		
		CheckoutPage checkoutPage = cartPage.checkout();
		checkoutPage.clickHereToLoginLink();
		TimeUnit.SECONDS.sleep(3);
		
		checkoutPage.
		            login(user).
		            setBillingAddress(billingAddress).
	                placeOrder();
		TimeUnit.SECONDS.sleep(5);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
	}

}
