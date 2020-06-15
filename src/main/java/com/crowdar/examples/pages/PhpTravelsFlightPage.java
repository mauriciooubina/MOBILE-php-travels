package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PhpTravelsFlightPage extends PageBasePhpTravels {

    private final String FIRST_RESULT = "#LIST > li:nth-child(%s) > div > div.theme-search-results-item-preview > div.row > form > div.col-md-2 > div > button";

    public PhpTravelsFlightPage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void clickFirstResult(String result) {clickElement(By.cssSelector(String.format(FIRST_RESULT, result)));}
}
