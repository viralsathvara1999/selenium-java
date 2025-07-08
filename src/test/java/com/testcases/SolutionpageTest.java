package com.testcases;

import org.example.base.BaseClass;
import org.example.enums.DriverTypes;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.SolutionPage;
import org.example.utility.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SolutionpageTest {

    WebDriver driver;
    HomePage homePage;
    SolutionPage solutionPage;


    @BeforeClass
    public void setup() {
        BaseClass.initializeDriver(DriverTypes.CHROME);
        driver = BaseClass.getDriver(); // Safe to use now
        homePage = new HomePage(driver);
        solutionPage= new SolutionPage(driver);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void validateNavigateToDifferentPageToHome()  {
        Log.startTestCase("Start......validate User is able to Navigating through different pages");
        String expectedTitle = "Property Management";
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title does not contain 'Entrata'");
        Log.endTestCase("END.....validate User is able to Navigating through different pages");
    }

    @Test(priority = 2)
    public void validateNavigateToDiffrentpageToSolutions(){
        Log.startTestCase("Start......validate User is able to Navigating through different pages");
        solutionPage.selectStudentOnSolution("Solutions","Student");
        String expectedTitle = "Student Housing Management";
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title does not contain 'Student Housing Management'");
        Log.endTestCase("END.....validate User is able to Navigating through different pages");
    }

    @Test(priority = 3)
    public void validateNavigateToDifferentPageToProducts(){
        Log.startTestCase("Start......validate User is able to Navigating through different pages");
        solutionPage.selectStudentOnSolution("Products","LeadManager");
        String expectedTitle = "LeadManager";
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title does not contain 'LeadManager'");
        Log.endTestCase("END.....validate User is able to Navigating through different pages");
    }

    @Test(priority = 4)
    public void validateNavigateToDifferentPageToResources(){
        Log.startTestCase("Start......validate User is able to Navigating through different pages");
        solutionPage.selectStudentOnSolution("Resources","Theme Gallery");
        String expectedTitle = "Theme Gallery";
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title does not contain 'Theme Gallery'");
        driver.navigate().back();
        Log.endTestCase("END.....validate User is able to Navigating through different pages");
    }
}
