package com.kayak.pages;

import com.kayak.core.driver.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class Kayak extends KayakPageBase {

    public Kayak(WebDriver driver) {
        super(driver);
        setPath("flights");
        navigate();
        this.actions = new Actions(driver);
    }
    private Actions actions;
    public String stop1;
    public String stop2;
    public int bestPrice;
    public int flyQueue;

    @FindBy(css = "[class=\"J_T2-field-group J_T2-mod-collapse-l J_T2-mod-spacing-y-xxsmall J_T2-mod-spacing-x-xxsmall J_T2-mod-grow J_T2-mod-no-min-width\"]")
    private WebElement navigateControl;

    @FindBy(css = "[class=\"qMs4-main qMs4-mod-dialog-variant-popup\"]")
    private WebElement cookieControl;

    @FindBy(css = "[class=\"qMs4-close\"]")
    private WebElement cookie;

    @FindBy(css = "[class=\"c_neb-item-close\"]")
    private WebElement airportClose;

    @FindBy(css = "[placeholder=\"From?\"]")
    private WebElement airportFrom;

    @FindBy(css = "[placeholder=\"To?\"]")
    private WebElement airportTo;

    @FindBy(css = "[class=\"c_lY1-title\"]")
    private WebElement passengers;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div[2]/div/div/div[1]/div/button[2]")
    private WebElement adult;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div[2]/div/div/div[2]/div/button[2]")
    private WebElement student;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div[2]/div/div/div[4]/div/button[2]")
    private WebElement child;

    @FindBy(css = "[class=\"gI3K-submit\"]")
    private WebElement search;

    @FindBy(css = "[aria-label=\"Start date\"]")
    private WebElement startDate;

    @FindBy(css = "[aria-label=\"Next Month\"]")
    private WebElement nextMonth;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div[1]/div[2]/div[1]/div/div[3]/table/tbody/tr[1]/td[7]/div")
    private WebElement twoDec;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div[1]/div[2]/div[1]/div/div[3]/table/tbody/tr[4]/td[4]/div")
    private WebElement twentyDec;

    @FindBy(css = "[aria-label=\"End date\"]")
    private WebElement endDate;

    @FindBy(xpath = "//*[@id=\"leftRail\"]/div/div[1]/div[1]/div/div[2]/span")
    private WebElement loading;

    @FindBy(css = "[aria-label=\"Book on KAYAK\"]")
    private WebElement bookOnKayakCheck;

    @FindBy(id = "valueSetFilter-vertical-whisky-whisky-label")
    private WebElement bookOnKayak;

    @FindBy(css = "[class=\"Fxw9\"] [class=\"nrc6 nrc6-mod-pres-default\"]")
    private List<WebElement> flyList;

    @FindBy(css = "[class=\"ULvh-button show-more-button\"]")
    private WebElement showMoreResult;

    @FindBy(css = "[aria-label=\"Quickest\"] [class=\"Hv20-title\"]")
    private WebElement quickest;

    @FindBy(css = "[class=\"hJSA-item\"]:nth-child(1) [class=\"vmXl vmXl-mod-variant-default\"] span")
    private List<WebElement> oneStop1;

    @FindBy(css = "[class=\"hJSA-item\"]:nth-child(2) [class=\"vmXl vmXl-mod-variant-default\"] span")
    private List<WebElement> oneStop2;

    @FindBy(css = "[class=\"hJSA-item\"]:nth-child(1) [class=\"vmXl vmXl-mod-variant-large\"] span:nth-child(1)")
    private List<WebElement> clock1;

    @FindBy(css = "[class=\"hJSA-item\"]:nth-child(1) [class=\"vmXl vmXl-mod-variant-large\"] span:nth-child(1)")
    private List<WebElement> clock2;

    @FindBy(css = "[class=\"f8F1-price-text\"]")
    private List<WebElement> price;

    @FindBy(css = "[class=\"rW4w-subtitle\"]")
    private WebElement checkDate;

    @FindBy(css = "[class=\"NITa NITa-travelers NITa-hide-below-m NITa-hasValue NITa-mod-presentation-expanded\"] span:nth-child(2)")
    private WebElement checkPassengerCount;

    @FindBy(css = "[class=\"M_JD-booking-btn\"] [role=\"link\"]")
    private List<WebElement> viewDeal;

    @FindBy(css = "[class=\"fpiRow\"] dd")
    private WebElement secondPagePrice;

    @FindBy(css = "[class=\"nx9J-title\"]")
    private WebElement secondPageFlyPlace;

    @FindBy(css = "[class=\"nx9J-text\"] span:nth-child(2)")
    private WebElement secondPageFlyDate;

    @FindBy(css = "[class=\"yw9m-subtitle\"]")
    private WebElement secondPageFlySummary;

    public void navigateControl() {
        waitUntilVisibleWebElement(navigateControl);
    }

    public void clickCookie() {
        waitUntilVisibleWebElement(cookieControl);
        waitUntilVisibleWebElement(cookie).click();
    }

    public void setAirport(String from, String to) throws InterruptedException {
        waitUntilVisibleWebElement(airportClose).click();
        waitUntilVisibleWebElement(airportFrom).clear();
        airportFrom.sendKeys(from);
        Thread.sleep(1000);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        waitUntilVisibleWebElement(airportTo).clear();
        airportTo.sendKeys(to);
        Thread.sleep(1000);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void setPassengers(){
        waitUntilVisibleWebElement(passengers).click();
        waitUntilVisibleWebElement(adult).click();
        waitUntilVisibleWebElement(student).click();
        waitUntilVisibleWebElement(child).click();
    }

    public void setDate(){
        waitUntilVisibleWebElement(startDate).click();
        waitUntilVisibleWebElement(nextMonth).click();
        waitUntilVisibleWebElement(twoDec).click();
        waitUntilVisibleWebElement(twentyDec).click();
    }

    public void search() throws InterruptedException {
        waitUntilVisibleWebElement(search).click();
        Thread.sleep(5000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size()>1) {
            driver.switchTo().window(tabs.get(1));
        }
    }

    public void bookOnKayak() throws InterruptedException {
        waitUntilVisibleWebElement(bookOnKayak);
        scrollToElement(bookOnKayak).click();
        waitUntilVisibleWebElement(quickest);
        scrollToElement(quickest).click();
        long startTime = System.currentTimeMillis();
        while (elementSize(flyList)<50){
            Thread.sleep(1000);
            waitUntilVisibleWebElement(showMoreResult).click();
            Thread.sleep(2000);
            elementSize(flyList);
            System.out.println(flyList.size());
            if (System.currentTimeMillis() - startTime > 180000)
                Assert.assertTrue("flyList are not visible", false);
        }
    }

    public void findCheapest(){

        int best=0;
        for(int i = 0; i<oneStopSize(); i++){
            if (oneStop1.get(i).getText().contains("1 stop")
                    && oneStop2.get(i).getText().contains("1 stop")
                    && clock1.get(i).getText().contains("pm")
                    && clock2.get(i).getText().contains("pm")) {
                if(getPrice(price,i) > best){
                    best = getPrice(price,i);
                    bestPrice = best;
                    flyQueue = i;
                }
                stop1 = oneStop1.get(i).getText();
                stop2 = oneStop2.get(i).getText();
                bestPrice = best;
                break;
            }
        }
    }

    public int elementSize(List<WebElement> element){
        return element.size();
    }

    public int getPrice(List<WebElement> element, int i){
        String price= element.get(i).getText();
        String part1 = (price.substring(1, 2));
        String part2 = (price.substring(3, 6));
        return Integer.parseInt(part1+part2);
    }

    public int oneStopSize(){
        return oneStop1.size();
    }

    public String checkDate(){
        System.out.println(checkDate.getText());
        return checkDate.getText();
    }

    public String checkPassengers(){
        return checkPassengerCount.getText();
    }

    public String checkSecondPageFlyPlace(){
        return secondPageFlyPlace.getText();
    }

    public String checkSecondPageFlyDate(){
        return secondPageFlyDate.getText();
    }

    public String checkSecondPageFlySummary(){
        return secondPageFlySummary.getText();
    }

    public double getSecondPagePrice(){
        String cleanPrice = secondPagePrice.getText().replace("$", "").replace(",", "");

        return Double.parseDouble(cleanPrice);
    }

    public void setViewDeal() throws InterruptedException {
        waitUntilVisibleWebElement(viewDeal.get(flyQueue));
        scrollToElement(viewDeal.get(flyQueue)).click();
        Thread.sleep(5000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size()>2) {
            driver.switchTo().window(tabs.get(2));
        }
        else{
            driver.switchTo().window(tabs.get(1));
        }
    }


    public WebElement scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

}
