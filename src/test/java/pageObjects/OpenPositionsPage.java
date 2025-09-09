package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Locators.OpenPositionsPageLocators;

import java.util.List;

public class OpenPositionsPage extends BasePage {
    public OpenPositionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private String selectedDepartment;
    private String selectedLocation;

    public void selectLocation(String location) {
        WebElement dropdown = waitClickable(OpenPositionsPageLocators.LOCATION_DROPDOWN);
        dropdown.click();

        By option = By.xpath(String.format(OpenPositionsPageLocators.LOC_OPTION_XPATH, location));
        WebElement locationOption = waitVisibility(option);

        scrollToElement(option);

        locationOption.click();
        this.selectedLocation = location;
    }

    public void isLocationSelected(String expectedLocation) {
        WebElement selected = waitVisibility(OpenPositionsPageLocators.LOCATION_DROPDOWN);
        String actual = selected.getAttribute("title").trim();
        Assert.assertEquals(actual, expectedLocation, "Dropdown seçimi yanlış!");
    }

    public void selectDepartment(String department) {
        WebElement dropdown = waitClickable(OpenPositionsPageLocators.DEPARTMENT_DROPDOWN);
        dropdown.click();

        By option = By.xpath(String.format(OpenPositionsPageLocators.DEPARTMENT_OPTION_XPATH, department));
        WebElement departmentOption = waitVisibility(option);

        scrollToElement(option);

        departmentOption.click();
        this.selectedDepartment = department;
    }

    public void isDepartmentSelected(String expectedDepartment) {
        WebElement selected = waitVisibility(OpenPositionsPageLocators.DEPARTMENT_DROPDOWN);
        String actualTitle = selected.getAttribute("title");

        Assert.assertEquals(actualTitle, expectedDepartment, "Department title is incorrect!");
    }

    public void checkJobsListDisplaying() {
        waitVisibility(OpenPositionsPageLocators.JOBS_LIST_CONTAINER);
    }

    public void checkJobsListFiltered(String expectedTitleSubstring) {
        waitVisibility(OpenPositionsPageLocators.JOBS_LIST_CONTAINER);
        WebElement jobsList = waitVisibility(OpenPositionsPageLocators.JOBS_LIST_CONTAINER);
        List<WebElement> jobs = jobsList.findElements(OpenPositionsPageLocators.JOB_ITEM);
        Assert.assertTrue(jobs.size() > 0, "No QA jobs found!");

        for (WebElement job : jobs) {
            String title = job.findElement(OpenPositionsPageLocators.JOB_TITLE).getText().trim();
            String location = job.findElement(OpenPositionsPageLocators.JOB_LOCATION).getText().trim();
            String department = job.findElement(OpenPositionsPageLocators.JOB_DEPARTMENT).getText().trim();

            Assert.assertTrue(title.contains(expectedTitleSubstring),
                    "Job title does not contain expected text! Title: " + title);

            Assert.assertEquals(location, selectedLocation,
                    "Job location is different than selected! Title: " + title + ", Location: " + location);

            Assert.assertEquals(department, selectedDepartment,
                    "Job department is different than selected! Title: " + title + ", Department: " + department);
        }
    }

    public void scrollToFilters() {
        scrollToElementTop(OpenPositionsPageLocators.TOP_FILTER_FORM);
    }

    public void scrollToJobsList() {
        scrollToElement(OpenPositionsPageLocators.JOBS_LIST_CONTAINER);
    }

    public void checkViewRoleOpensLeverForm(int jobIndex, String expectedUrlPart) {
        List<WebElement> jobs = driver.findElements(OpenPositionsPageLocators.JOB_ITEM);
        WebElement viewRoleButton = jobs.get(jobIndex).findElement(OpenPositionsPageLocators.VIEW_ROLE_BUTTON);
        viewRoleButton.click();

        checkNewTabUrlAndReturn(expectedUrlPart);
    }

}