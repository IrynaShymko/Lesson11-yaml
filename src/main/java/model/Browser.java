package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Browser {
    private String browserName;
    private int webElementTimeOut;
    private int webBrowserImplicitTimeOut;
    private static Logger logger = LoggerFactory.getLogger("Browser.class");

    public String getBrowserName() {
        return browserName;
    }

    public int getWebElementTimeOut() {
        return webElementTimeOut;
    }

    public int getWebBrowserImplicitTimeOut() {
        return webBrowserImplicitTimeOut;
    }

}
