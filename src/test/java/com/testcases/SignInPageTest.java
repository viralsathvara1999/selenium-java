package com.testcases;

import org.example.base.BaseClass;
import org.example.enums.DriverTypes;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.SignInpage;
import org.example.pageobjects.SolutionPage;
import org.example.pageobjects.SummitPage;
import org.example.utility.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SignInPageTest {


        WebDriver driver;
        HomePage homePage;
        SolutionPage solutionPage;
        SummitPage summitPage;
        SignInpage signInpage;

        @BeforeClass
        public void setup() {
            BaseClass.initializeDriver(DriverTypes.CHROME);
            driver = BaseClass.getDriver(); // Safe to use now
            homePage = new HomePage(driver);
            solutionPage= new SolutionPage(driver);
            summitPage = new SummitPage(driver);
            signInpage = new SignInpage(driver);
        }

        @AfterClass
        public void teardown(){
            driver.quit();
        }


        @Test
        public void validateUserRedirectToSignPageAndChangeLanguage(){
            Log.startTestCase("Start......validate User is able to Navigating through Sign In Page and change language");
            signInpage.clickOnSignIn();
            String expectedTitle = "Entrata Sign In";
            String actualTitle = driver.getTitle();
            System.out.println("Page Title is: " + actualTitle);
            Assert.assertTrue(actualTitle.contains(expectedTitle), "Title does not contain 'Advanced Apartments'");
            signInpage.clickOnResidentLogin();
            signInpage.clickOnLangTranslationButton();
            signInpage.clickOnEsLanguage();
            signInpage.clickOnSave();
            Log.endTestCase("END.....validate User is able to Navigating through Sign In Page and change language");
        }

}





