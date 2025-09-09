package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CareerPage;
import pageObjects.HomePage;
import pageObjects.OpenPositionsPage;
import pageObjects.QAPage;
import utils.BaseTest;
import utils.TestSetup;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners(TestListener.class)
public class CareerPageTests extends BaseTest {

    private TestSetup setUp;
    private HomePage homePage;
    private CareerPage careerPage;
    private QAPage qaPage;
    private OpenPositionsPage openPositionsPage;

    @BeforeMethod
    public void setUp() throws Exception {
        setUp = new TestSetup();
        homePage = setUp.pageObjectManager.getHomePage();
        careerPage = setUp.pageObjectManager.getCareerPage();
        qaPage = setUp.pageObjectManager.getQAPage();
        openPositionsPage = setUp.pageObjectManager.getOpenPositionsPAge();
    }

    @Test
    public void testCareerPageNavigation() {
        careerPage.closeCookieIfPresent();
        homePage.hooverCareer();
        homePage.clickCareerPage();
        careerPage.checkCareerPageIsOpened();
        int initialTeamCount = careerPage.getVisibleTeamCount();
        System.out.println("İnitial team count: " + initialTeamCount);
        careerPage.expandAllTeams();
        careerPage.waitForTeamsToExpand(initialTeamCount);
        int expandedTeamCount = careerPage.getVisibleTeamCount();
        System.out.println("All teams count: " + expandedTeamCount);
        careerPage.navigateToLocationsGlider();
        careerPage.validateLocationsGlider();
        careerPage.navigateToLifeAtInsider();
        careerPage.validateLifeAtInsiderSection();
    }

    @Test
    public void testCareerQAOpenPositionsIst() {
        careerPage.closeCookieIfPresent();
        homePage.hooverCareer();
        homePage.clickCareerPage();
        careerPage.checkCareerPageIsOpened();
        careerPage.expandAllTeams();
        careerPage.clickSelectedTeam("Quality Assurance");
        qaPage.checkQAPageIsOpened();
        qaPage.clickToAllJobsBtn();
        openPositionsPage.scrollToFilters();
        openPositionsPage.selectLocation("Istanbul, Turkiye");
        openPositionsPage.selectDepartment("Quality Assurance");
        openPositionsPage.isLocationSelected("Istanbul, Turkiye");
        openPositionsPage.isDepartmentSelected("Quality Assurance");
        openPositionsPage.checkJobsListDisplaying();

    }

    @Test
    public void testQAOpenPositionsList() {
        homePage.hooverCareer();
        homePage.clickCareerPage();
        careerPage.closeCookieIfPresent();
        careerPage.expandAllTeams();
        careerPage.clickSelectedTeam("Quality Assurance");
        qaPage.checkQAPageIsOpened();
        qaPage.clickToAllJobsBtn();
        openPositionsPage.scrollToFilters();
        openPositionsPage.selectLocation("Istanbul, Turkiye");
        openPositionsPage.selectDepartment("Quality Assurance");
        openPositionsPage.isLocationSelected("Istanbul, Turkiye");
        openPositionsPage.isDepartmentSelected("Quality Assurance");
        openPositionsPage.checkJobsListFiltered("Quality Assurance");
    }

    @Test
    public void testQAApplicationForm() {
        homePage.hooverCareer();
        homePage.clickCareerPage();
        careerPage.closeCookieIfPresent();
        careerPage.expandAllTeams();
        careerPage.clickSelectedTeam("Quality Assurance");
        qaPage.checkQAPageIsOpened();
        qaPage.clickToAllJobsBtn();
        openPositionsPage.scrollToFilters();
        openPositionsPage.selectLocation("Istanbul, Turkiye");
        openPositionsPage.selectDepartment("Quality Assurance");
        openPositionsPage.isLocationSelected("Istanbul, Turkiye");
        openPositionsPage.isDepartmentSelected("Quality Assurance");
        openPositionsPage.checkViewRoleOpensLeverForm(0,"lever");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
