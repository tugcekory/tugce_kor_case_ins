package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    private static Logger log = Logger.getLogger(BasePage.class);


    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Click Method
    public void click(By by) {
        waitClickable(by).click();
    }

    //Wait
    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void hover(By by) {
        WebElement element = waitVisibility(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void scrollToElement(By by) {
        WebElement element = waitVisibility(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollToElementTop(By by) {
        WebElement element = waitVisibility(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'start', inline: 'nearest'});", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public void closeCookieIfPresent() {
        By cookieCloseBtn = By.id("wt-cli-reject-btn");
        try {
            WebElement closeBtn = waitClickable(cookieCloseBtn);
            closeBtn.click();
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }

    public void checkPageUrl(String urlText) {
        String pageSource = driver.getPageSource();
        boolean containsText = pageSource.contains(urlText);
        if (containsText) {
            System.out.println("URL contains " + urlText);
        } else {
            System.out.println("URL does not contain " + urlText);
        }
    }

    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void checkNewTabUrlAndReturn(String expectedUrlPart) {
        switchToNewTab();

        checkPageUrl(expectedUrlPart);

        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }
}