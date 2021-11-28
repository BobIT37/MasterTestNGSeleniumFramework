package com.masterframework.pom.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
	
	private final By countryDropDown = By.id("billing_country");
	private final By stateDropDown = By.id("billing_state");
	private final By alternateCountryDropDown = By.id("select2-billing_country-container");
	private final By alternateStateDropDown = By.id("select2-billing_state-container");

	private final By productName = By.cssSelector("td[class='product-name']");

	private final By directBankTransferRadioBtn = By.id("payment_method_bacs");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public CheckoutPage enterFirstName(String firstName) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameFld));
		element.clear();
		element.sendKeys(firstName);
		return this;
	}

	public CheckoutPage load(){
		load("/checkout/");
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
				selectCountry(billingAddress.getCountry()).
				enterAddressLineOne(billingAddress.getAddressLineOne()).
				enterCity(billingAddress.getCity()).
				selectState(billingAddress.getState()).
				enterPostCode(billingAddress.getPostalCode()).
				enterEmail(billingAddress.getEmail());
		
	}
	
	public CheckoutPage selectCountry(String countryName) {
//		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(countryDropDown)));
//		select.selectByVisibleText(countryName);
		wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='Turkey']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
//		By alternateCountryDropDown = By.id("select2-billing_country-container");
//		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Turkey']")));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", e);
//		e.click();
//		return this;
	}
	
	public CheckoutPage selectState(String stateName) {
//		Select select = new Select(driver.findElement(stateDropDown));
//		select.selectByVisibleText(stateName);
//		return this;
		wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='Ankara']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
	}

	public String getProductName() throws Exception {
		int i = 5;
		while(i > 0){
			try {
				return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
			}catch (StaleElementReferenceException e){
				System.out.println("NOT FOUND. TRYING AGAIN" + e);
			}
			Thread.sleep(5000);
			i--;
		}
		throw new Exception("Element not found");
	}

	public CheckoutPage selectDirectBankTransfer(){
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
		if(!e.isSelected()){
			e.click();
		}
		return this;
	}

}
