package org.example.pageobjects;

import org.example.actiondriver.Action;
import org.example.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Viral Sathvara added on july 2025
 *
 */

public class SolutionPage extends BaseClass {

    Action action= new Action();
    WebDriver driver;

    public SolutionPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//nav[@role='navigation']/child::a[text()='Summit']")
    private WebElement summit;

    @FindBy(xpath="//a[@href='https://nexusdemo.prospectportal.com/' and contains(text(), 'desktop_mac')]")
    private WebElement click_On_Desktop_iCon;


    public void selectStudentOnSolution(String page1,String page2){
        action.mouseOverElement(driver,driver.findElement(By.xpath("//nav//div[text()='"+page1+"']")));
        WebElement el = driver.findElement(By.xpath("//div[text()='"+page2+"']"));
        el.click();
    }

    public void clickOnIcon(){
        action.JSClick(driver,click_On_Desktop_iCon);
    }

    public void clickOnSubmit(){
        action.click(driver,summit);
    }


}
