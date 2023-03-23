package com.blazeclan.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void enterText(WebElement element, String text) {


		element.clear();
		Log.info("Text in the element is " + element  +"is cleared");
		element.click();
		Log.info("Cliked on textbox " +element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		element.sendKeys(text);
		Log.info("Entered text on " +element +" text");







	}

	public void clickElement(WebElement element) {


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		Log.info("wait for until element "+ element.toString() + "is visible");
		element.click();
		Log.info("Clicked on element " +element);

	}


}
