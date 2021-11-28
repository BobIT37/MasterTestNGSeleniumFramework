package com.masterframework.pom.pages;

import com.masterframework.pom.pages.components.MyHeader;
import com.masterframework.pom.pages.components.ProductThumbnail;
import org.openqa.selenium.WebDriver;
import com.masterframework.pom.base.BasePage;


public class HomePage extends BasePage{
	public MyHeader getMyHeader() {
		return myHeader;
	}

	public ProductThumbnail getProductThumbnail() {
		return productThumbnail;
	}

	private MyHeader myHeader;
	private ProductThumbnail productThumbnail;

	public HomePage(WebDriver driver) {
		super(driver);
		myHeader = new MyHeader(driver);
		productThumbnail = new ProductThumbnail(driver);
	}

	public HomePage load(){
		load("/");
		return this;
	}

}
