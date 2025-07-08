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

public class SignInpage extends BaseClass {

        Action action= new Action();
        WebDriver driver;

        public SignInpage(WebDriver driver) {
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        @FindBy(xpath="//div[@class='nav_buttons']/a[text()='Sign in']")
        private WebElement signin_button;

        @FindBy(xpath="//div[text()='Resident Login']")
        private WebElement Resident_lod_in_button;

        @FindBy(className = "lang-translation")
        private WebElement lang_tanslation_button;

       @FindBy(xpath="//span[@data-text='lang_en']")
       private WebElement clickOnEn;

       @FindBy(xpath="//span[@data-text='lang_es']")
       private WebElement clickOnEs;

       @FindBy(xpath="//button[text()='Save']")
       private WebElement clickOnSave;


        public void clickOnSignIn(){
            action.click(driver,signin_button);
        }

       public void clickOnResidentLogin(){
        action.click(driver,Resident_lod_in_button);
        }

       public void clickOnLangTranslationButton(){
        action.explicitWait(driver,lang_tanslation_button,5);
        action.click(driver,lang_tanslation_button);
       }

       public void clickOnEsLanguage(){
        action.click(driver,clickOnEs);
       }

      public void clickOnSave(){
        action.click(driver,clickOnSave);
      }


}
