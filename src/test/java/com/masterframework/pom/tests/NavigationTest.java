package com.masterframework.pom.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.masterframework.pom.base.BaseTest;
import com.masterframework.pom.pages.HomePage;
import com.masterframework.pom.pages.StorePage;

public class NavigationTest extends BaseTest {

    @Test
    public void NavigateFromHomeToStoreUsingMainMenu(){
        StorePage storePage = new HomePage(getDriver()).
                load().
                navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getTitle(), "Store");
    }
}