package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public HomePage homePage;
    public CareerPage careerPage;
    public QAPage qaPage;
    public OpenPositionsPage openPositionsPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }

    public CareerPage getCareerPage() {
        careerPage = new CareerPage(driver);
        return careerPage;
    }

    public QAPage getQAPage() {
        qaPage = new QAPage(driver);
        return qaPage;
    }

    public OpenPositionsPage getOpenPositionsPAge() {
        openPositionsPage = new OpenPositionsPage(driver);
        return openPositionsPage;
    }

 }