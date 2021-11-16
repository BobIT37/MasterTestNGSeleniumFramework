package com.masterframework.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.masterframework.pom.base.BasePage;

public class CartPage extends BasePage{
	
	private final By prodcutName = By.cssSelector("td[class='product-name'] a");
	private final By checkoutBtn = By.cssSelector(".checkout-button");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public String getProductName() {
		return driver.findElement(prodcutName).getText();
	}
	
	public CheckoutPage checkout() {
		driver.findElement(checkoutBtn).click();
		return new CheckoutPage(driver);
	}

}
