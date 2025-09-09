package pageObjects.Locators;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static final By HEADER_INSIDER_BY = By.xpath("//*[@id='navigation']/div[2]/a[1]/img");

    public static final By MENU_COMPANY_BY = By.xpath("//a[normalize-space(text())='Company']");

    public static final By MENU_COMPANY_CAREER_BY = By.xpath("//*[@id='navbarNavDropdown']/ul[1]/li[6]/div/div[2]/a[2]");
}
