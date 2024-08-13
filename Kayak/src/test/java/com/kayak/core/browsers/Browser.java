package com.kayak.core.browsers;


public enum Browser {
    CHROME(ChromeBrowser.class),
    FIREFOX(FirefoxBrowser.class),
    SAFARI(SafariBrowser .class),
    IE(IEBrowser.class),
    EDGE(EdgeBrowser.class);

    private Class<? extends BrowserBase> browserClass;

    Browser(Class<? extends BrowserBase> browserClass) {
        this.browserClass = browserClass;
    }

    public Class<? extends BrowserBase> getBrowserClass() {
        return browserClass;
    }

}
