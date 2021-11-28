package com.masterframework.pom.dataproviders;

import com.masterframework.pom.objects.Products;
import com.masterframework.pom.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyDataProvider {
    @DataProvider(name = "getFeaturedProducts", parallel = false)
    public Object[] getFeaturedProducts() throws IOException {
        return JacksonUtils.deserializeJson("products.json", Products[].class);
    }
}
