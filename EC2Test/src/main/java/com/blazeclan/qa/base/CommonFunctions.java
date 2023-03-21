package com.blazeclan.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.blazeclan.qa.logging.Log;
import com.blazeclan.qa.utility.CrossBrowser;

public class CommonFunctions {

	public static WebDriver driver;
	public static Properties init_properties(String path)   {

		Properties prop = new Properties();
		try {
			File file = new File(path);
			if (!file.exists()) {
				throw new FileNotFoundException("File doesn't exits");
			}
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public String captureScreenshot(String screenshotName, String result) {
		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);


		String destPath = "./screenshots/" + result + "/" + screenshotName + "_" + date + ".png";
		File destFile = new File(destPath);

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destPath;
	}
	
	public void invokeBrowser(String browserName) {
		driver = CrossBrowser.selectDriver(browserName);
		Log.info("Opened "+ browserName +" browser" );
		driver.manage().window().maximize();
		Log.info("Window is maximized");
	}

	public void invokeApplicationURL(String url) {
		driver.get(url);
		Log.info("Opened URL is  " +url);
	}

}
