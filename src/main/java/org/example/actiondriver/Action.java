package org.example.actiondriver;

import org.apache.maven.shared.utils.io.FileUtils;
import org.example.base.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;



    /**
     * @author Viral Sathvara added on july 2025
     *
     */
    public class Action extends BaseClass implements ActionInterface {

        @Override
        public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", ele);

        }

        @Override
        public void click(WebDriver driver, WebElement ele) {

            Actions act = new Actions(driver);
            act.moveToElement(ele).click().build().perform();

        }

        @Override
        public boolean findElement(WebDriver driver, WebElement ele) {
            boolean flag = false;
            try {
                ele.isDisplayed();
                flag = true;
            } catch (Exception e) {
                // System.out.println("Location not found: "+locatorName);
                flag = false;
            } finally {
                if (flag) {
                    System.out.println("Successfully Found element at");

                } else {
                    System.out.println("Unable to locate element at");
                }
            }
            return flag;
        }

        @Override
        public boolean isDisplayed(WebDriver driver, WebElement ele) {
            boolean flag = false;
            flag = findElement(driver, ele);
            if (flag) {
                flag = ele.isDisplayed();
                if (flag) {
                    System.out.println("The element is Displayed");
                } else {
                    System.out.println("The element is not Displayed");
                }
            } else {
                System.out.println("Not displayed ");
            }
            return flag;
        }

        /**
         * Type text at location
         *
         * @param ele
         * @param text
         * @return - true/false
         */
        @Override
        public boolean type(WebElement ele, String text) {
            boolean flag = false;
            try {
                flag = ele.isDisplayed();
                ele.clear();
                ele.sendKeys(text);
                // logger.info("Entered text :"+text);
                flag = true;
            } catch (Exception e) {
                System.out.println("Location Not found");
                flag = false;
            } finally {
                if (flag) {
                    System.out.println("Successfully entered value");
                } else {
                    System.out.println("Unable to enter value");
                }

            }
            return flag;
        }



        /**
         * select value from DD by using value
         *
         * @param element    : Action to be performed on element (Get it from Object
         *                    repository)
         *
         * @param value       : Value wish to select from dropdown list.
         *
         */

        @Override
        public boolean selectByValue(WebElement element,String value) {
            boolean flag = false;
            try {
                Select s = new Select(element);
                s.selectByValue(value);
                flag = true;
                return true;
            } catch (Exception e) {

                return false;
            } finally {
                if (flag) {
                    System.out.println("Option selected by Value");
                } else {
                    System.out.println("Option not selected by Value");
                }
            }
        }



        @Override
        public boolean JSClick(WebDriver driver, WebElement ele) {
            boolean flag = false;
            try {
                // WebElement element = driver.findElement(locator);
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", ele);
                // driver.executeAsyncScript("arguments[0].click();", element);

                flag = true;

            }

            catch (Exception e) {
                throw e;

            } finally {
                if (flag) {
                    System.out.println("Click Action is performed");
                } else if (!flag) {
                    System.out.println("Click Action is not performed");
                }
            }
            return flag;
        }


        @Override
        public void mouseOverElement(WebDriver driver,WebElement element) {
            boolean flag = false;
            try {
                new Actions(driver).moveToElement(element).build().perform();
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (flag) {
                    System.out.println(" MouserOver Action is performed on ");
                } else {
                    System.out.println("MouseOver action is not performed on");
                }
            }
        }


        /**
         * Verify alert present or not
         *
         * @return: Boolean (True: If alert preset, False: If no alert)
         *
         */
        @Override
        public boolean Alert(WebDriver driver) {
            boolean presentFlag = false;
            Alert alert = null;

            try {
                // Check the presence of alert
                alert = driver.switchTo().alert();
                // if present consume the alert
                alert.accept();
                presentFlag = true;
            } catch (NoAlertPresentException ex) {
                // Alert present; set the flag

                // Alert not present
                ex.printStackTrace();
            } finally {
                if (!presentFlag) {
                    System.out.println("The Alert is handled successfully");
                } else{
                    System.out.println("There was no alert to handle");
                }
            }

            return presentFlag;
        }
        @Override
        public boolean launchUrl(WebDriver driver,String url) {
            boolean flag = false;
            try {
                driver.navigate().to(url);
                flag = true;
                return true;
            } catch (Exception e) {
                return false;
            } finally {
                if (flag) {
                    System.out.println("Successfully launched \""+url+"\"");
                } else {
                    System.out.println("Failed to launch \""+url+"\"");
                }
            }
        }

        @Override
        public boolean isAlertPresent(WebDriver driver)
        {
            try
            {
                driver.switchTo().alert();
                return true;
            }   // try
            catch (NoAlertPresentException Ex)
            {
                return false;
            }   // catch
        }


        @Override
        public String getCurrentURL(WebDriver driver)  {
            boolean flag = false;

            String text = driver.getCurrentUrl();
            if (flag) {
                System.out.println("Current URL is: \""+text+"\"");
            }
            return text;
        }

        @Override
        public void implicitWait(WebDriver driver, int timeOut) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        @Override
        public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
            WebDriverWait wait = new WebDriverWait(driver,timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
        }

        @Override
        public String screenShot(WebDriver driver, String filename) {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

            try {
                FileUtils.copyFile(source, new File(destination));
            } catch (Exception e) {
                e.getMessage();
            }
            // This new path for jenkins
            String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
                    + dateName + ".png";
            return newImageString;
        }


    }


