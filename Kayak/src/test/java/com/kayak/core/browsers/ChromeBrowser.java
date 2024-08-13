package com.kayak.core.browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ChromeBrowser extends BrowserBase {

    ChromeOptions chromeOptions;
    public ChromeBrowser() {
        super(DesiredCapabilities.chrome(), "chromedriver");
    }

    @Override
    void configure(DesiredCapabilities caps, Platform platform, File driverFile) {
        System.setProperty("webdriver.chrome.driver", driverFile.getPath());

        chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("process-per-site");
        chromeOptions.addArguments("--dns-prefetch-disable");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        chromeOptions.setExperimentalOption("prefs", prefs);


        if (platform == Platform.LINUX) {
            chromeOptions.addArguments("headless");
        }

        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    }

    @Override
    RemoteWebDriver create() {
        return new ChromeDriver(chromeOptions);
    }
}
