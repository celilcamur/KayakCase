package com.kayak.core.browsers;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;

public class SafariBrowser extends BrowserBase {
    SafariOptions safariOptions;
    public SafariBrowser() {
        super(DesiredCapabilities.safari(), "safari");
    }

    @Override
    void configure(DesiredCapabilities caps, Platform platform, File driverFile) {
        System.setProperty("webdriver.safari.noinstall", driverFile.getPath());
        safariOptions = new SafariOptions();

        caps = new DesiredCapabilities(safariOptions);
        caps.setCapability(SafariOptions.CAPABILITY,safariOptions);
    }

    @Override
    RemoteWebDriver create() {
        return new SafariDriver(safariOptions);
    }
}
