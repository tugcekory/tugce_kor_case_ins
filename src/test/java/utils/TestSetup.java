package utils;

import java.io.IOException;
import pageObjects.PageObjectManager;

public class TestSetup {

    public PageObjectManager pageObjectManager;
    public BaseTest baseTest;

    public TestSetup() throws IOException {
        baseTest = new BaseTest();
        pageObjectManager = new PageObjectManager(baseTest.WebDriverManager());
    }


}
