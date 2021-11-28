package com.masterframework.pom.factory.abstractFactory;

import com.masterframework.pom.constants.DriverType;

public class DriverManagerFactoryAbstract {

    public static DriverManagerAbstract getManager(DriverType driverType){
        switch (driverType){
            case CHROME:
                return new ChromeDriverManagerAbstract();
        case FIREFOX:
                return new FirefoxDriverManagerAbstract();
            default: throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
