package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PhpTravelsBillingPage extends PageBasePhpTravels  {

    private final String USERNAME_EMAIL = "username";
    private final String USERNAME_PASSWORD = "password";
    private final String NAME = "#name";
    private final String SURNAME = "#surname";
    private final String MAIL = "#email";
    private final String PHONE = "phone";
    private final String BIRTHDAY = "birthday";
    private final String PASSPORT = "cardno";
    private final String EXPIRATION = "expiration";
    private final String NATIONALITY = "nationality";
    private final String CARD = "cardtype";
    private final String CARD_VISA = "#cardtype > option:nth-child(5)";
    private final String CARD_NUMBER = "card-number";
    private final String CARD_MONTH = "expiry-month";
    private final String MONTH = "#expiry-month > option:nth-child(%s)";
    private final String CARD_YEAR = "expiry-year";
    private final String YEAR = "#expiry-year > option:nth-child(%s)";
    private final String CARD_CVV = "cvv";
    private final String CONDITIONS = "body > div.body-inner > div > div.main-wrapper.scrollspy-action > div.page-wrapper.page-payment.bg-light > div > div > div.col-12.col-lg-8 > div > div.content-wrapper > form > div.custom-control.custom-checkbox.form-group.acceptterm > label";
    private final String CHECKING = "confirmBooking";

    public PhpTravelsBillingPage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void writeEmail(String mail) {completeField(By.id(USERNAME_EMAIL), mail);}

    public void writePassword(String psw) {completeField(By.id(USERNAME_PASSWORD), psw);}

    public void writeName(String name) {
        WebElement namePath = driver.findElement(By.cssSelector(NAME));
        namePath.sendKeys(name);
    }

    public void writeSurname(String surname) {
        WebElement surnamePath = driver.findElement(By.cssSelector(SURNAME));
        surnamePath.sendKeys(surname);
    }

    public void writeMail(String email) {completeField(By.cssSelector(MAIL), email);}

    public void writePhone(String phone) {completeField(By.id(PHONE), phone);}

    public void writeBirthday(String birthday) {completeField(By.id(BIRTHDAY), birthday);}

    public void writePassport(String passport) {completeField(By.id(PASSPORT), passport);}

    public void writeExpiration(String expiration) {completeField(By.id(EXPIRATION), expiration);}

    public void writeNationality(String nationality) throws InterruptedException {
        WebElement departureField = driver.findElement(By.id(NATIONALITY));
        departureField.sendKeys(nationality);
        Thread.sleep(2000);
        departureField.sendKeys(Keys.ENTER);
    }

    public void selectCreditCard(String card) throws InterruptedException {
        clickElement(By.id(CARD));
        Thread.sleep(2000);
        clickElement(By.cssSelector(CARD_VISA));
    }

    public void writeCardNumber(String cardNumber) {completeField(By.id(CARD_NUMBER), cardNumber);}

    public void selectExpiration(String cardExpirateMonth, String cardExpirateYear) throws InterruptedException {
        clickElement(By.id(CARD_MONTH));
        Thread.sleep(1000);
        int month = Integer.parseInt(cardExpirateMonth) + 1;
        clickElement(By.cssSelector(String.format(MONTH, String.valueOf(month))));

        clickElement(By.id(CARD_YEAR));
        Thread.sleep(1000);
        int year = Integer.parseInt(cardExpirateYear) + 2;
        clickElement(By.cssSelector(String.format(YEAR, String.valueOf(year%10))));
    }

    public void writeCvv(String cvv) {completeField(By.id(CARD_CVV), cvv);}

    public void acceptConditions() {clickElement(By.cssSelector(CONDITIONS));}

    public void finishChecking() {clickElement(By.id(CHECKING));}


}
