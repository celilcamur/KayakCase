package com.kayak.core.browsers;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class IEBrowser extends BrowserBase {
    InternetExplorerOptions internetExplorerOptions;
    public IEBrowser() {
        super(DesiredCapabilities.internetExplorer(), "IE");
    }

    @Override
    void configure(DesiredCapabilities caps, Platform platform, File driverFile) {
        System.setProperty("webdriver.ie.driver", driverFile.getPath());

        internetExplorerOptions = new InternetExplorerOptions();

        internetExplorerOptions.destructivelyEnsureCleanSession();//Clear the Internet Explorer cache before launching the browser.
        internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();//to ignore protected mode settings during starting by IEDriverServer.
//        internetExplorerOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);//wait for the DOMContentLoaded event only

        caps =  DesiredCapabilities.internetExplorer();
        caps.setCapability("acceptSslCerts",true);
        caps.setCapability("nativeEvents", false);

    }

    @Override
    RemoteWebDriver create() {
        return new InternetExplorerDriver(internetExplorerOptions);
    }
}
