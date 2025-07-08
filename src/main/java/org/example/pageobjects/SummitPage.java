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

public class SummitPage extends BaseClass {


        Action action= new Action();
        WebDriver driver;

        public SummitPage(WebDriver driver) {
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        @FindBy(xpath="//a[@class='header-button w-button']")
        private WebElement Register_Button;


        public void ClickOnRegister(){
            action.click(driver,Register_Button);
        }


    }


