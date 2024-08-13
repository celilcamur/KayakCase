package com.kayak.pages;

import com.kayak.core.driver.WebDriver;
import com.kayak.core.pageobject.PageBase;

abstract class KayakPageBase extends PageBase {

    KayakPageBase(WebDriver driver) {
        super(driver);
        setBaseUrl("https://www.kayak.com");
    }


}
