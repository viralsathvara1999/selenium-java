package org.example.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


/**
 * @author Viral Sathvara added on july 2025
 *
 */
public class ExtentManager {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {

        htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "Test_Automation_Entrata");
        extent.setSystemInfo("Tester", "Viral");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }
    public static void endReport() {
        extent.flush();
    }
}

