package com.masterframework.pom.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.masterframework.pom.base.BaseTest;
import com.masterframework.pom.pages.StorePage;

public class SearchTest extends BaseTest{
	
	
	    @Test
	    public void searchWithPartialMatch() throws InterruptedException{
	        String searchFor = "Blue";
	        StorePage storePage = new StorePage(getDriver()).
	                load().
	                search(searchFor);
	        TimeUnit.SECONDS.sleep(5);
	        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
	    }

}
