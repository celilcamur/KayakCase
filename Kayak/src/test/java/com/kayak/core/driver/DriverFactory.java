package com.kayak.core.driver;

import com.kayak.core.browsers.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.utility.DockerImageName;

class DriverFactory {

    private static RemoteWebDriver REAL_DRIVER = null;
    private static final Logger LOGGER = Logger.getLogger(DriverFactory.class);
    private static final Thread CLOSE_THREAD = new Thread(DriverFactory::close);


    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    private static void newInstance() {
        boolean useDocker = false;
        try {
            close();
            String browserName = System.getProperty("BrowserName");
            if (browserName == null){
                if (useDocker) {
                    // Docker up
                    try (BrowserWebDriverContainer<?> browserContainer =
                                 new BrowserWebDriverContainer<>(DockerImageName.parse("selenium/standalone-chrome:latest"))
                                         .withCapabilities(DesiredCapabilities.chrome())) {

                        browserContainer.start();
                        REAL_DRIVER = new RemoteWebDriver(browserContainer.getWebDriver().getCapabilities());
                    }
                } else {
                    // Local
                    REAL_DRIVER = Browser.CHROME.getBrowserClass().newInstance().getDriver();
                    // auto driver download
//                WebDriverManager.chromedriver().setup();
//                REAL_DRIVER = new ChromeDriver();
                }

            }
            else if (browserName.equalsIgnoreCase("firefox"))
                REAL_DRIVER = Browser.FIREFOX.getBrowserClass().newInstance().getDriver();
            else if (browserName.equalsIgnoreCase("safari"))
                REAL_DRIVER = Browser.SAFARI.getBrowserClass().newInstance().getDriver();
            else if (browserName.equalsIgnoreCase("ie"))
                REAL_DRIVER = Browser.IE.getBrowserClass().newInstance().getDriver();
            else if (browserName.equalsIgnoreCase("edge"))
                REAL_DRIVER = Browser.EDGE.getBrowserClass().newInstance().getDriver();
            else
                REAL_DRIVER = Browser.CHROME.getBrowserClass().newInstance().getDriver();

        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("Driver creation fail", e);
        }
    }

    static RemoteWebDriver getDriver(boolean newInstance, boolean isTeardown) {
        if ((newInstance || REAL_DRIVER == null) && (!isTeardown && !isDriverUp())) {
            LOGGER.info("Creating new driver instance...");
            newInstance();
        }
        return REAL_DRIVER;
    }

    static boolean isDriverUp() {
        if (REAL_DRIVER == null)
            return false;
        return true;
    }

    public static void close() {
        if (REAL_DRIVER != null) {
            LOGGER.info("Closing driver instance...");
            REAL_DRIVER.quit();
            REAL_DRIVER = null;
        }
    }
}