package com.kayak.core.browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class FirefoxBrowser extends BrowserBase {
    FirefoxOptions firefoxOptions;
    public FirefoxBrowser() {
        super(DesiredCapabilities.firefox(), "geckodriver");
    }

    @Override
    void configure(DesiredCapabilities caps, Platform platform, File driverFile) {
        System.setProperty("webdriver.gecko.driver", driverFile.getPath());

        firefoxOptions = new FirefoxOptions();

        firefoxOptions.addArguments("--width=1920");
        firefoxOptions.addArguments("--height=1080");

        FirefoxProfile testprofile = new FirefoxProfile();
        testprofile.setPreference("credentials_enable_service", false);
        testprofile.setPreference("profile.password_manager_enabled", false);
        testprofile.setPreference("dom.webnotifications.enabled", false);
        testprofile.setPreference("browser.cache.disk.enable", false);
        testprofile.setPreference("browser.cache.memory.enable", false);
        testprofile.setPreference("browser.cache.offline.enable", false);
        testprofile.setPreference("network.http.use-cache", false);

        firefoxOptions.setProfile(testprofile);

        if (platform == Platform.LINUX) {
            firefoxOptions.addArguments("headless");
        }
        caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS,firefoxOptions);
    }

    @Override
    RemoteWebDriver create() {
        return new FirefoxDriver(firefoxOptions);
    }
}
