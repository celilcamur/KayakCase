package com.kayak.steps;

import com.kayak.core.driver.WebDriver;
import com.kayak.core.managers.ScreenshotManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import java.io.IOException;

public class StepHooks {

    private WebDriver webDriver;

    public StepHooks() {
        try {
            webDriver = new WebDriver(true);
        } catch (NullPointerException e) {
        }
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            if (webDriver != null)
                ScreenshotManager.saveFailScenarioScreenshot(webDriver, scenario);
        }
        if (webDriver != null) {
            System.out.println("cookies deleted...");
            webDriver.manage().deleteAllCookies();
            webDriver.closeDriver();
        }
    }
}
