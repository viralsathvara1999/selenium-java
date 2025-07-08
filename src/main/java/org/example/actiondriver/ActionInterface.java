package org.example.actiondriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {

    //Added all user actions abstract methods to achieve Abstraction
    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
    public void click(WebDriver ldriver, WebElement ele);
    public boolean isDisplayed(WebDriver ldriver, WebElement ele);
    public boolean type(WebElement ele, String text);
    public boolean findElement(WebDriver ldriver, WebElement ele);
    public boolean selectByValue(WebElement element,String value);
    public boolean JSClick(WebDriver driver, WebElement ele);
    public void mouseOverElement(WebDriver driver,WebElement element);
    public boolean Alert(WebDriver driver);
    public boolean launchUrl(WebDriver driver,String url);
    public boolean isAlertPresent(WebDriver driver);
    public String getCurrentURL(WebDriver driver);
    public void implicitWait(WebDriver driver, int timeOut);
    public void explicitWait(WebDriver driver, WebElement element, int timeOut);
    public String screenShot(WebDriver driver, String filename);


}
