package com.masterframework.pom.tests;

import com.masterframework.pom.api.actions.CartApi;
import com.masterframework.pom.api.actions.SignUpApi;
import com.masterframework.pom.base.BaseTest;
import com.masterframework.pom.objects.User;
import com.masterframework.pom.objects.Products;
import com.masterframework.pom.pages.CheckoutPage;
import com.masterframework.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginDuringCheckout() throws Exception {
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demopwd").
                setEmail(username + "@askomdch.com");

        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        CartApi cartApi = new CartApi();
        Products product = new Products(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();
        checkoutPage.
                clickHereToLoginLink().
                login(user);
        Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()));

    }
}
