package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Locators.CareerPageLocators;

import java.time.Duration;
import java.util.List;

public class CareerPage extends BasePage {

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public void checkCareerPageIsOpened() {
        WebElement element = waitVisibility(CareerPageLocators.OPEN_POS_BUTTON_BY);
        Assert.assertTrue(element.isDisplayed(), "Career page is not opened or button is not visible");
    }

    public void expandAllTeams() {
        scrollToElement(CareerPageLocators.SEE_ALL_TEAMS_BTN);
        waitClickable(CareerPageLocators.SEE_ALL_TEAMS_BTN).click();
    }

    public void clickSelectedTeam(String teamName) {
        By teamLocator = By.xpath("//h3[normalize-space(text())='" + teamName + "']");
        scrollToElement(teamLocator);
        click(teamLocator);
    }

    public int getVisibleTeamCount() {
        List<WebElement> teams = driver.findElements(CareerPageLocators.TEAM_CARDS);
        return teams.size();
    }

    public void waitForTeamsToExpand(int currentCount) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> getVisibleTeamCount() > currentCount);

        int expandedCount = getVisibleTeamCount();
        if (expandedCount <= currentCount) {
            throw new AssertionError("No new teams appeared after clicking 'See all teams'!");
        }
    }

    public void navigateToLocationsGlider() {
        scrollToElement(CareerPageLocators.LOCATIONS_GLIDER);
    }

    public boolean isLocationsGliderVisible() {
        try {
            waitVisibility(CareerPageLocators.LOCATIONS_GLIDER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> getLocationSlides() {
        return waitVisibility(CareerPageLocators.LOCATIONS_GLIDER)
                .findElements(CareerPageLocators.LOCATION_SLIDES);
    }

    public void validateLocationsGlider() {
        if (!isLocationsGliderVisible()) {
            throw new AssertionError("Location glider is not visible!");
        }

        List<WebElement> slides = getLocationSlides();
        if (slides.isEmpty()) {
            throw new AssertionError("No location slides found!");
        }

        int slidesToCheck = Math.min(2, slides.size());
        for (int i = 0; i < slidesToCheck; i++) {
            WebElement slide = slides.get(i);
            String country = slide.findElement(CareerPageLocators.LOCATION_COUNTRY).getText().trim();
            String city = slide.findElement(CareerPageLocators.LOCATION_CITY).getText().trim();

            if (country.isEmpty()) {
                throw new AssertionError("Country is empty on slide " + i);
            }
            if (city.isEmpty()) {
                throw new AssertionError("City is empty on slide " + i);
            }

            System.out.println("Slide " + i + ": " + country + ", " + city);
        }
    }

    public void navigateToLifeAtInsider() {
        scrollToElement(CareerPageLocators.LIFE_AT_INSIDER_HEADING);
    }

    public void validateLifeAtInsiderSection() {
        WebElement heading = driver.findElement(CareerPageLocators.LIFE_AT_INSIDER_HEADING);
        if (!heading.isDisplayed()) {
            throw new AssertionError("'Life at Insider' heading is not visible!");
        }

        WebElement text = driver.findElement(CareerPageLocators.LIFE_AT_INSIDER_TEXT);
        if (!text.isDisplayed() || text.getText().isEmpty()) {
            throw new AssertionError("'Life at Insider' text is not visible or empty!");
        }

        System.out.println("'Life at Insider' heading and text validated.");
    }
}