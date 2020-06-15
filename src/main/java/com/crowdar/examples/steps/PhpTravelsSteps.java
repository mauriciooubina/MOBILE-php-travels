package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.PhpTravelsBillingPage;
import com.crowdar.examples.pages.PhpTravelsFlightPage;
import com.crowdar.examples.pages.PhpTravelsHomePage;
import com.crowdar.examples.pages.PhpTravelsSearchResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class PhpTravelsSteps extends PageSteps {

    @Given("The app is loaded correctly")
    public void home() throws InterruptedException {
        Thread.sleep(5000);
    }

    @When("the client searchs for a flight in (.*) from (.*) to (.*) for the date (.*) and (.*)")
    public void theClientSearchsForARoundTripFlight(String flightType , String departure, String destination, String date, String returnDate) throws InterruptedException {
        Injector._page(PhpTravelsHomePage.class).selectFlight();
        Injector._page(PhpTravelsHomePage.class).clickFlightType(flightType);
        Injector._page(PhpTravelsHomePage.class).writeDeparture(departure);
        Injector._page(PhpTravelsHomePage.class).writeDestination(destination);
        Injector._page(PhpTravelsHomePage.class).selectDateFlight(date);
        Injector._page(PhpTravelsHomePage.class).selectReturnDateFlight(returnDate);
    }

    @And("its for (.*) adult (.*) child (.*) infant")
    public void select(String adults, String child, String infant){
        Injector._page(PhpTravelsHomePage.class).selectCorrectTravelers(adults, child, infant);
        Injector._page(PhpTravelsHomePage.class).clickSearchButton();
    }

    @And("clicks the (.*) result writing email (.*) password (.*)")
    public void clicksTheResultWriting(String result, String mail, String psw) {
        Injector._page(PhpTravelsFlightPage.class).clickFirstResult(result);
        Injector._page(PhpTravelsBillingPage.class).writeEmail(mail);
        Injector._page(PhpTravelsBillingPage.class).writePassword(psw);
    }


    @And("completes with name (.*) Surname (.*) email (.*) phone (.*) birthday (.*) passport (.*) expiration (.*) nationality (.*)")
    public void writePersonalInformation(String name, String surname, String email, String phone, String birthday, String passport, String expiration, String nationality) throws InterruptedException {
        Injector._page(PhpTravelsBillingPage.class).writeName(name);
        Injector._page(PhpTravelsBillingPage.class).writeSurname(surname);
        Injector._page(PhpTravelsBillingPage.class).writeMail(email);
        Injector._page(PhpTravelsBillingPage.class).writePhone(phone);
        Injector._page(PhpTravelsBillingPage.class).writeBirthday(birthday);
        Injector._page(PhpTravelsBillingPage.class).writePassport(passport);
        Injector._page(PhpTravelsBillingPage.class).writeExpiration(expiration);
        Injector._page(PhpTravelsBillingPage.class).writeNationality(nationality);
    }

    @And("pays with (.*) number (.*) expiration month (.*) year (.*) cvv (.*)")
    public void writePaymentInformation(String card, String cardNumber, String cardExpirateMonth,String cardExpirateYear, String cvv) throws InterruptedException {
        Injector._page(PhpTravelsBillingPage.class).selectCreditCard(card);
        Injector._page(PhpTravelsBillingPage.class).writeCardNumber(cardNumber);
        Injector._page(PhpTravelsBillingPage.class).selectExpiration(cardExpirateMonth, cardExpirateYear);
        Injector._page(PhpTravelsBillingPage.class).writeCvv(cvv);
        Injector._page(PhpTravelsBillingPage.class).acceptConditions();
        Injector._page(PhpTravelsBillingPage.class).finishChecking();
    }

    @Then("A reservation number is not provide")
    public void statVerification() {
        //Assert.assertTrue(!Injector._page(PhpTravelsSearchResultPage.class).getStats().isEmpty());
        Injector._page(PhpTravelsSearchResultPage.class).waitForError();
        Assert.assertEquals(Injector._page(PhpTravelsSearchResultPage.class).getTitle(),"Booking");
    }
}
