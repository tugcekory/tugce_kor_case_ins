package pageObjects.Locators;

import org.openqa.selenium.By;

public class OpenPositionsPageLocators {

    public static final By VIEW_ROLE_BUTTON = By.cssSelector("a.btn-navy");
    public static final By LOCATION_DROPDOWN = By.id("select2-filter-by-location-container");
    public static final String LOC_OPTION_XPATH = "//li[contains(@class,'select2-results__option') and text()='%s']";
    public static final By DEPARTMENT_DROPDOWN = By.id("select2-filter-by-department-container");
    public static final String DEPARTMENT_OPTION_XPATH = "//li[contains(@class,'select2-results__option') and text()='%s']";
    public static final By JOBS_LIST_CONTAINER = By.id("jobs-list");
    public static final By TOP_FILTER_FORM = By.id("top-filter-form");
    public static final By JOB_ITEM = By.cssSelector(".position-list-item");
    public static final By JOB_DEPARTMENT = By.cssSelector(".position-department");
    public static final By JOB_LOCATION = By.cssSelector(".position-location");
    public static By JOB_TITLE = By.cssSelector(".position-title");
}
