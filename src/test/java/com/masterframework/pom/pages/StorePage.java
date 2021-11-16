package com.masterframework.pom.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.masterframework.pom.base.BasePage;

public class StorePage extends BasePage{
	
	private final By searchFld = By.id("woocommerce-product-search-field-0");
	private final By searchBtn = By.cssSelector("button[value='Search']");
	private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
	private final By viewCartLink = By.cssSelector("a[title='View cart']");
	
	public StorePage(WebDriver driver) {
		super(driver);
	}
	
	public StorePage search(String txt) throws InterruptedException {
		enterTextInSearchFld(txt).clickSearchBtn();
		return this;
	}

	private StorePage enterTextInSearchFld(String txt) throws InterruptedException {
		driver.findElement(searchFld).sendKeys(txt);
		TimeUnit.SECONDS.sleep(5);
		return this;
		
	}
	
	private StorePage clickSearchBtn() {
		driver.findElement(searchBtn).click();
		return this;
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	
	private By getAddToCartBtnElement(String productName) {
		return By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");
	}
	
	public StorePage clickAddToCartBtn(String productName) {
		By addToCartBtn = getAddToCartBtnElement(productName);
		driver.findElement(addToCartBtn).click();
		return this;
	}
	
	public CartPage clickViewCart() {
		driver.findElement(viewCartLink).click();
		return new CartPage(driver);
	}
}
