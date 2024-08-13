package com.kayak.steps.kayak;

import com.kayak.pages.*;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class KayakSteps {
    private Kayak kayak;

    public KayakSteps(Kayak kayak) {
        this.kayak = kayak;
    }

    public void navigate(){
        kayak.navigateControl();
        kayak.clickCookie();
    }

    public void setAirport(String from, String to) throws InterruptedException {
        kayak.setAirport(from, to);
    }


    public void setPassengers() {
        kayak.setPassengers();
    }

    public void setDate() {
        kayak.setDate();
    }

    public void setSearch() throws InterruptedException {
        kayak.search();
    }

    public void setBookOnKayak() throws InterruptedException {
        kayak.bookOnKayak();
    }

    public void findTheCheapest() {
        kayak.findCheapest();
    }

    public void checkDate() {
        System.out.println(kayak.checkDate());
        Assert.assertTrue("Date is wrong", kayak.checkDate().equals("Sat, Nov 2 - Wed, Nov 20"));
    }

    public void checkPassengerCount() {
        Assert.assertTrue("Passenger count is wrong", kayak.checkPassengers().equals("4 travelers"));
    }

    public void checkOneStop() {
        Assert.assertTrue("Passenger count is wrong", kayak.stop1.equals("1 stop"));
        Assert.assertTrue("Passenger count is wrong", kayak.stop2.equals("1 stop"));
    }

    public void checkPrice() throws InterruptedException {
        kayak.setViewDeal();
        double price1 = (kayak.bestPrice*4);
        double price2 = kayak.getSecondPagePrice();
        double tolerancePercentage = 0.05;
        double tolerance = Math.abs(price1 * tolerancePercentage / 100.0);
        double difference = Math.abs(price1 - price2);
        Assert.assertTrue("Final price is wrong", difference<=tolerance);
    }

    public void checkSecondPage() throws InterruptedException {
        Assert.assertTrue("Fly date is wrong", kayak.checkSecondPageFlyPlace().equals("Doha - Tokyo"));
        Assert.assertTrue("Fly place is wrong", kayak.checkSecondPageFlyDate().equals("Sat, Nov 2 - Wed, Nov 20"));
        Assert.assertTrue("Fly summary is wrong", kayak.checkSecondPageFlySummary().equals("Round-trip, Economy, 3 adults, 1 child"));
    }

    @When("^I navigate kayak page$")
    public void iNavigateKayak() throws InterruptedException {
        navigate();
    }

    @When("^I check the fly$")
    public void iCheckTheFly() throws InterruptedException {
        checkDate();
        checkPassengerCount();
        checkOneStop();
        checkPrice();
    }

    @When("^I check the final fly page$")
    public void iCheckTheFinalFlyPage() throws InterruptedException {
        checkPrice();
        checkSecondPage();
    }

    @When("^I am going to booking from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iAmGoingToBookingFromTo(String from, String to) throws InterruptedException {
        setAirport(from, to);
        setPassengers();
        setDate();
        setSearch();
        setBookOnKayak();
        findTheCheapest();
    }

}
