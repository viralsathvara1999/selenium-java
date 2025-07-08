/**
 *
 */
package org.example.pageobjects;

import org.example.actiondriver.Action;
import org.example.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/**
 * @author Viral Sathvara added on july 2025
 *
 */
public class HomePage extends BaseClass {

    Action action= new Action();
    WebDriver driver;

    @FindBy(xpath="//div[@class='logo_component w-embed']")
    private WebElement Entratalogo;

    @FindBy(id="FirstName")
    private WebElement firstname;

    @FindBy(id="LastName")
    private WebElement lastname;

    @FindBy(id="Email")
    private WebElement email;

    @FindBy(id="Company")
    private WebElement companyName;

    @FindBy(id="Phone")
    private WebElement phone;

    @FindBy(id="Title")
    private WebElement jobTitle;

    @FindBy(id="Unit_Count__c")
    private WebElement selectUnit;

    @FindBy(id="demoRequest")
    private WebElement resident_type;

    @FindBy(xpath = "//span[text()='Order history and details']")
    private WebElement orderHistory;

    @FindBy(xpath="//div[text()='This field is required.']")
    private WebElement error_xpath;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement button_click;

    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public boolean validateLoGoIsDisplayed() throws Throwable {
        return action.isDisplayed(driver, Entratalogo);
    }

    public void enterFirstName(String name){
      action.scrollByVisibilityOfElement(driver,firstname);
      action.type(firstname,name);
    }

    public void enterLastName(String name){
        action.type(lastname,name);
    }

    public void enterEmail(String emailid){
        action.type(email, emailid);
    }
    public void enterCompanyName(String name){
        action.type(companyName,name);
    }
    public void enterPhone(String no){
        action.type(phone,no);
    }
    public void entertitle(String title){
        action.type(jobTitle, title);
    }

    public void selectManagedunits(String units){
        action.selectByValue(selectUnit,units);
    }

    public void selectresidentType(String type){
        action.selectByValue(resident_type,type);
    }

    public boolean validateErrorIsDisplayed(){
        return action.isDisplayed(driver,error_xpath);
    }

    public void clickButton(){
        action.click(driver,button_click);
        action.screenShot(driver,"xyz");
    }


}
