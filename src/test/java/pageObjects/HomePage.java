package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.Locators.HomePageLocators;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void checkHomePageIsOpened() {
        waitVisibility(HomePageLocators.HEADER_INSIDER_BY);
    }

    public void hooverCareer() {
        hover(HomePageLocators.MENU_COMPANY_BY);
    }

    public void clickCareerPage() {
        waitClickable(HomePageLocators.MENU_COMPANY_CAREER_BY).click();
    }


}
