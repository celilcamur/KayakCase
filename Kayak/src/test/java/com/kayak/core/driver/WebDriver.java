package com.kayak.core.driver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriver extends EventFiringWebDriver {

    public WebDriver() {
        super(DriverFactory.getDriver(true, false));
    }

    public WebDriver(boolean isTeardown) {
        super(DriverFactory.getDriver(true, isTeardown));
    }

    public void closeDriver() {
        DriverFactory.close();
    }


}
