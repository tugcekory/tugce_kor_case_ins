package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Locators.QAPageLocators;


public class QAPage extends BasePage{
    public QAPage(WebDriver driver) {
        super(driver);
    }

    public void checkQAPageIsOpened() {
        WebElement element = waitVisibility(QAPageLocators.SEE_ALL_QA_JOBS_BTN);
        Assert.assertTrue(element.isDisplayed(), "QA page is not opened or button is not visible");
    }

    public void clickToAllJobsBtn() {
        waitClickable(QAPageLocators.SEE_ALL_QA_JOBS_BTN).click();
    }


}
