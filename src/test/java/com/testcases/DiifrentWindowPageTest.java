package com.testcases;

import org.example.base.BaseClass;
import org.example.enums.DriverTypes;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.SolutionPage;
import org.example.pageobjects.SummitPage;
import org.example.utility.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DiifrentWindowPageTest {

        WebDriver driver;
        HomePage homePage;
        SolutionPage solutionPage;
        SummitPage summitPage;

        @BeforeClass
        public void setup() {
            BaseClass.initializeDriver(DriverTypes.CHROME);
            driver = BaseClass.getDriver(); // Safe to use now
            homePage = new HomePage(driver);
            solutionPage= new SolutionPage(driver);
            summitPage = new SummitPage(driver);
        }

        @AfterClass
        public void teardown(){
            driver.quit();
        }


        @Test(priority = 1)
        public void validateNavigateToDiffrentWindowsTo(){
            Log.startTestCase("Start......validate User is able to Navigating through different windows");
            solutionPage.selectStudentOnSolution("Resources","Theme Gallery");
            solutionPage.clickOnIcon();
            System.out.println("Page Title is: " + driver.getTitle());

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            String expectedTitle = "Advanced Apartments";
            String actualTitle = driver.getTitle();
            System.out.println("Page Title is: " + actualTitle);
            Assert.assertTrue(actualTitle.contains(expectedTitle), "Title does not contain 'Advanced Apartments'");
            driver.close();
            driver.switchTo().window(tabs.get(0));
            driver.navigate().back();
            Log.endTestCase("END.....validate User is able to Navigating through different windows");
        }

        @Test(priority = 2)
        public void validateNavigateToDifferentPageToProducts() throws InterruptedException {
            Log.startTestCase("Start......validate User is able to Navigating through different windows");
            solutionPage.clickOnSubmit();

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            String expectedTitle = "Entrata Summit 2025";
            String actualTitle = driver.getTitle();
            System.out.println("Page Title is: " + actualTitle);
            Assert.assertTrue(actualTitle.contains(expectedTitle), "Title does not contain 'Entrata Summit 2025'");
            summitPage.ClickOnRegister();
            driver.switchTo().window(tabs.get(0));
            Log.endTestCase("END.....validate User is able to Navigating through different windows");
        }


}



