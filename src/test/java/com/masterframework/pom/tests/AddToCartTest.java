package com.masterframework.pom.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.masterframework.pom.base.BaseTest;
import com.masterframework.pom.objects.Products;
import com.masterframework.pom.pages.CartPage;
import com.masterframework.pom.pages.StorePage;

public class AddToCartTest extends BaseTest{
	
	@Test
    public void addToCartFromStorePage() throws IOException {
        Products product = new Products(1215);
        CartPage cartPage = new StorePage(getDriver()).load().
                clickAddToCartBtn(product.getName()).
                clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }

}
