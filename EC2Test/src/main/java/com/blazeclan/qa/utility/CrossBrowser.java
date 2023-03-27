package com.blazeclan.qa.utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.blazeclan.qa.base.CommonFunctions;
import com.blazeclan.qa.logging.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser extends CommonFunctions {
//	public static WebDriver selectDriver(String browser) {
//		if (browser.equalsIgnoreCase("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (browser.equalsIgnoreCase("Firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else {
//
//		}
//
//		Log.info("chrome browser selected");
	public static WebDriver selectDriver( String browser) {
        switch (browser) {
            case "chrome": //chrome driver
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--remote-debugging-port=9222")  ;
                options.addArguments("--disable-dev-shm-using") ;
                options.addArguments("--disable-extensions") ;
                options.addArguments("--disable-gpu") ;
                options.addArguments("start-maximized"); 
                options.addArguments("disable-infobars");
               
                // Log.info("chrome browser is selected");

                driver=(WebDriverManager.chromedriver().capabilities(options).create());
              //  Log.info("chrome browser is selected");
                break;
            case "firefox"://firefox driver
               // Log.info("firefox browser is selected");
                driver=(WebDriverManager.firefoxdriver().create());
                break;
            case "edge"://edge driver
                Log.info("edge browser is selected");
                driver=(WebDriverManager.edgedriver().create());
                break;
            default: Log.info("Please provide browser name");
        }


		DriverManager.setDriver(driver);
		return DriverManager.getDriver();
}
}