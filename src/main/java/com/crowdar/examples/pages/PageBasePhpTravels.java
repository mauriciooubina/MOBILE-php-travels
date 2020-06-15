package com.crowdar.examples.pages;

import com.crowdar.core.pageObjects.PageBaseWeb;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageBasePhpTravels extends PageBaseWeb {

    public PageBasePhpTravels(RemoteWebDriver driver) {
        super(driver);
        BASE_URL = "http://phptravels.net/";
    }


}
