package com.crowdar.examples.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class PhpTravelsHomePage extends PageBasePhpTravels {

    private final String FLIGHT_BUTTON = "com.phptravelsnative:id/progress_bar";
    private final String ONEWAY_FLIGHT = "#flights > div > div > form > div > div.row.mb-10.row-reverse.align-items-start.row-return > div.col-8 > div > div:nth-child(1) > label";
    private final String RETURN_TRIP = "#flights > div > div > form > div > div.row.mb-10.row-reverse.align-items-start.row-return > div.col-8 > div > div:nth-child(2) > label";
    private final String FLIGHT_OPTION = "com.phptravelsnative:id/image_economy";
    private final String SELECT_FLY_TYPE = "com.phptravelsnative:id/tv_trip_class";
    private final String DEPARTURE = "com.phptravelsnative:id/tv_cityto";
    private final String DEPARTURE_LOCATION ="com.phptravelsnative:id/auto_search";
    private final String FIRST_RESULT_DEPARTURE = "com.phptravelsnative:id/city_name";
    private final String DESTINATION = "com.phptravelsnative:id/tv_cityfrom";
    private final String DESTINATION_LOCATION = "com.phptravelsnative:id/auto_search";
    private final String FIRST_RESULT_DESTINATION = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
    private final String DATE_PLACE = "com.phptravelsnative:id/tv_fromdate";
    private final String SELECT_DATE = "22 June 2020";
    private final String OK_BUTTON = "android:id/button1";
    private final String DATE_RETURN_PLACE = "com.phptravelsnative:id/tv_dateretun";
    private final String SELECT_RETURN_DATE = "30 June 2020";
    private final String TRAVELERS = "com.phptravelsnative:id/iv_adult";
    private final String ADULT = "com.phptravelsnative:id/a_number";
    private final String CHILD = "com.phptravelsnative:id/c_number";
    private final String INFANT = "com.phptravelsnative:id/f_number";
    private final String INCREASE_TRAVELER = "com.phptravelsnative:id/%s_increase";
    private final String DECREASE_TRAVELER  = "com.phptravelsnative:id/%s_decrease";
    private final String DONE_BUTTON = "com.phptravelsnative:id/tv_positive_btn";
    private final String SEARCH_BUTTON = "com.phptravelsnative:id/search_hotels";


    public PhpTravelsHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void go() {
        navigateToCompleteURL();
    }

    /*public void waitForAppToLoad() {
        waitForElementVisibility(MobileBy.id(FLIGHT_BUTTON));
    }*/

    public void selectFlight(){clickElement(MobileBy.id(FLIGHT_BUTTON));}

    public void selectTripType(String tripType) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.cssSelector(ONEWAY_FLIGHT));
    }

    public void selectReturnFlight(String tripType) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.cssSelector(RETURN_TRIP));
    }

    public void clickFlightType(String flightType) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(MobileBy.id(SELECT_FLY_TYPE));
        clickElement(MobileBy.id(FLIGHT_OPTION));
    }

    public void writeDeparture(String departure) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(MobileBy.id(DEPARTURE));
        Thread.sleep(2000);
        completeField(MobileBy.id(DEPARTURE_LOCATION), departure);
        clickElement(MobileBy.id(FIRST_RESULT_DEPARTURE));
    }

    public void writeDestination(String destination) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(MobileBy.id(DESTINATION));
        completeField(MobileBy.id(DESTINATION_LOCATION), destination);
        clickElement(MobileBy.xpath(FIRST_RESULT_DESTINATION));
    }

    public void selectDateFlight(String date) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(MobileBy.id(DATE_PLACE));
        Thread.sleep(1000);
        clickElement(MobileBy.AccessibilityId(SELECT_DATE));
        clickElement(MobileBy.id(OK_BUTTON));
    }

    public void selectReturnDateFlight(String returnDate) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(MobileBy.id(DATE_RETURN_PLACE));
        Thread.sleep(1000);
        clickElement(MobileBy.AccessibilityId(SELECT_RETURN_DATE));
        clickElement(MobileBy.id(OK_BUTTON));
    }

    public void selectCorrectTravelers(String adults, String child, String infant) {
        clickElement(MobileBy.id(TRAVELERS));

        WebElement adultCount = driver.findElement(MobileBy.id(ADULT));
        writeProperTraveler("a", Integer.parseInt(adults), Integer.parseInt(adultCount.getAttribute("text")));

        WebElement childCount = driver.findElement(MobileBy.id(CHILD));
        writeProperTraveler("c", Integer.parseInt(adults), Integer.parseInt(childCount.getAttribute("text")));

        WebElement infantCount = driver.findElement(MobileBy.id(INFANT));
        writeProperTraveler("f", Integer.parseInt(adults), Integer.parseInt(infantCount.getAttribute("text")));

        clickElement(MobileBy.id(DONE_BUTTON));
    }

    private void writeProperTraveler(String selectorPos, int wantedTravelers, int actualTravelers) {
        if(actualTravelers<wantedTravelers) {
            for (int i = actualTravelers; i < wantedTravelers; i++) {
                clickElement(MobileBy.id(String.format(INCREASE_TRAVELER, selectorPos)));
            }
        }
    }

    public void clickSearchButton() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(MobileBy.id(SEARCH_BUTTON));
    }

}
