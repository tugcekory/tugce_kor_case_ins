package pageObjects.Locators;

import org.openqa.selenium.By;

public class CareerPageLocators {

    public static final By OPEN_POS_BUTTON_BY = By.xpath("//a[contains(text(),'Find your dream job')]");
    public static final By TEAM_CARDS = By.cssSelector("div.career-load-more .job-item");
    public static final By SEE_ALL_TEAMS_BTN = By.cssSelector("a.loadmore");
    public static final By LOCATIONS_GLIDER = By.cssSelector("section#career-our-location ul.glide__slides");
    public static final By LOCATION_SLIDES = By.cssSelector("section#career-our-location ul.glide__slides li.glide__slide");
    public static final By LOCATION_CITY = By.cssSelector(".location-info p.mb-0");
    public static final By LOCATION_COUNTRY = By.cssSelector(".location-info span:first-of-type");
    public static final By LIFE_AT_INSIDER_HEADING = By.xpath("//h2[text()='Life at Insider']");
    public static final By LIFE_AT_INSIDER_TEXT = By.xpath("//h2[text()='Life at Insider']/following::p[1]");

}
