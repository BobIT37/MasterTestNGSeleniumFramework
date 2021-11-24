package com.masterframework.pom.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.masterframework.pom.base.BasePage;

public class StorePage extends BasePage{
	
	private final By searchFld = By.id("woocommerce-product-search-field-0");
	private final By searchBtn = By.cssSelector("button[value='Search']");
	private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
	private final By viewCartLink = By.cssSelector("a[title='View cart']");
	
	public StorePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isLoaded() {
		return wait.until(ExpectedConditions.urlContains("/store"));
	}
	
	public StorePage search(String txt) throws InterruptedException {
		enterTextInSearchFld(txt).clickSearchBtn();
		return this;
	}

	private StorePage enterTextInSearchFld(String txt) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);;
		return this;
		
	}
	
	public StorePage load(){
        load("/store");
        return this;
    }
	
	private StorePage clickSearchBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
		return this;
	}
	
	public String getTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
	}
	
	private By getAddToCartBtnElement(String productName) {
		return By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");
	}
	
	public StorePage clickAddToCartBtn(String productName) {
		By addToCartBtn = getAddToCartBtnElement(productName);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
		return this;
	}
	
	public CartPage clickViewCart() {
		wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
		return new CartPage(driver);
	}
}
