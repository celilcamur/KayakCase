package com.kayak.core.browsers;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class EdgeBrowser extends BrowserBase {
    EdgeOptions edgeOptions;
    public EdgeBrowser() {
        super(DesiredCapabilities.edge(), "MicrosoftWebDriver.exe");
    }

    @Override
    void configure(DesiredCapabilities caps, Platform platform, File driverFile) {
        System.setProperty("webdriver.edge.driver", driverFile.getPath());

        edgeOptions = new EdgeOptions();

        caps =  DesiredCapabilities.edge();
        caps.setCapability("InPrivate", true);
        caps.setVersion("10.0");
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setAcceptInsecureCerts(true);
        caps.acceptInsecureCerts();

    }

    @Override
    RemoteWebDriver create() {
        return new EdgeDriver(edgeOptions);
    }
}