package com.masterframework.pom.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.masterframework.pom.base.BasePage;
import com.masterframework.pom.objects.BillingAddress;
import com.masterframework.pom.objects.User;

public class CheckoutPage extends BasePage{
	
	private final By firstnameFld = By.id("billing_first_name");
	private final By lastnameFld = By.id("billing_last_name");
	private final By addressLineOneFld = By.id("billing_address_1");
	private final By billingCityFld = By.id("billing_city");
	private final By billingPostCodeFld = By.id("billing_postcode");
	private final By billingEmailFld = By.id("billing_email");
	private final By placeOrderBtn = By.id("place_order");
	private final By successNotice = By.cssSelector(".woocommerce-notice");
	
	private final By clickHereToLoginLink = By.className("showlogin");
	private final By usernameFld = By.id("username");
	private final By passwordFld = By.id("password");
	private final By loginBtn = By.name("login");
	private final By overlay = By.cssSelector(".blockUI.blockOverlay");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public CheckoutPage enterFirstName(String firstName) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameFld));
		element.clear();
		element.sendKeys(firstName);
		return this;
	}
	
	public CheckoutPage enterLasttName(String lastName) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lastnameFld));
		element.clear();
		element.sendKeys(lastName);
		return this;
	}
	
	public CheckoutPage enterAddressLineOne(String addressLineOne) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(addressLineOneFld));
		element.clear();
		element.sendKeys(addressLineOne);
		return this;
	}
	
	public CheckoutPage enterCity(String city) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld));
		element.clear();
		element.sendKeys(city);;
		return this;
	}
	
	public CheckoutPage enterPostCode(String postCode) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostCodeFld));
		element.clear();
		element.sendKeys(postCode);
		return this;
	}
	
	public CheckoutPage enterEmail(String email) throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
		element.clear();
		element.sendKeys(email);;
		TimeUnit.SECONDS.sleep(5);
		return this;
	}
	
	public CheckoutPage placeOrder() {
		waitForOverlaysToDisappear(overlay);
		driver.findElement(placeOrderBtn).click();
		return this;
	}
	
	public String getNotice() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
	}
	
	public CheckoutPage clickHereToLoginLink() {
		wait.until(ExpectedConditions.elementToBeClickable(clickHereToLoginLink)).click();
		return this;
	}
	
	public CheckoutPage enterUserName(String username) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld));
		element.sendKeys(username);
		return this;
	}
	
	public CheckoutPage enterPassword(String password) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld));
		element.sendKeys(password);
		return this;
	}
	
	public CheckoutPage clickLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		return this;
	}
	
	public CheckoutPage login(User user) {
		return enterUserName(user.getUsername()).
			   enterPassword(user.getPassword()).
			   clickLoginBtn();
	  
	}
	
	public CheckoutPage setBillingAddress(BillingAddress billingAddress) throws InterruptedException {
		return enterFirstName(billingAddress.getFirstname()).
				enterLasttName(billingAddress.getLastname()).
				enterAddressLineOne(billingAddress.getAddressLineOne()).
				enterCity(billingAddress.getCity()).
				enterPostCode(billingAddress.getPostalCode()).
				enterEmail(billingAddress.getEmail());
		
	}

}
