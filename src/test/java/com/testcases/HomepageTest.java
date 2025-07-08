package com.testcases;

import org.example.base.BaseClass;
import org.example.enums.DriverTypes;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.SolutionPage;
import org.example.utility.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class HomepageTest {

    WebDriver driver;
    HomePage homePage;
    SolutionPage solutionPage;

    @BeforeMethod
    public void setup() {
        BaseClass.initializeDriver(DriverTypes.CHROME);
        driver = BaseClass.getDriver(); // Safe to use now
        homePage = new HomePage(driver);
        solutionPage= new SolutionPage(driver);
    }

    @AfterMethod
        public void teardown(){
            driver.quit();
        }

    @Test
    public void validateEntrataHomePage() throws Throwable {
        Log.startTestCase("START_____validate Home Page & validate error while submit form");
        String expectedTitle = "Entrata";
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title does not contain 'Entrata'");
        homePage.validateLoGoIsDisplayed();
        homePage.enterFirstName("Viral");
        homePage.enterLastName("Sathvara");
        homePage.enterEmail("viralsathvara1999@gmail.com");
        homePage.enterCompanyName("Google");
        homePage.enterPhone("1234567890");
        homePage.selectManagedunits("2000+");
        homePage.selectresidentType("a Resident");
        homePage.clickButton();
        homePage.validateErrorIsDisplayed();
        Log.endTestCase("End___validate Home Page & validate error while submit form");
    }

}


