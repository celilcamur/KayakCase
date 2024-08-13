package com.kayak.core.pageobject;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import com.kayak.core.driver.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class PageBase {

    protected WebDriver driver;
    private String baseUrl;
    private String path;

    protected PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(driver), this);
    }

    protected void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected void setPath(String path) {
        this.path = path;
    }

    public void navigate() {
        driver.get(String.join("/", baseUrl, path));
    }

    public WebElement waitUntilVisibleWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 35);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException e) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            waitUntilVisibleWebElement(element);
        }
        return element;
    }




}
