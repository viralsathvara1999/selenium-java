package org.example.base;

import org.apache.log4j.xml.DOMConfigurator;
import org.example.enums.DriverTypes;
import org.example.utility.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Viral Sathvara added on july 2025
 *
 */

public class BaseClass {

    public static Properties prop = new Properties();
    public static WebDriver driver;

    public static void loadConfig() {
        ExtentManager.setExtent();
        DOMConfigurator.configure(System.getProperty("user.dir") + "\\log4j.xml");

        try {
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties"
            );
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializeDriver(DriverTypes type) {
        loadConfig(); // ✅ Ensure config is loaded

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\";

        switch (type) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case CHROME:
            default:
                System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(
                Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(
                Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
