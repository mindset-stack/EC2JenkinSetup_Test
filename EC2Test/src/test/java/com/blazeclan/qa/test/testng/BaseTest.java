package com.blazeclan.qa.test.testng;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.blazeclan.qa.base.CommonFunctions;
import com.blazeclan.qa.conastants.IConstants;
import com.blazeclan.qa.pages.LoginPage;

public class BaseTest extends CommonFunctions {
	
	public  LoginPage loginpage;
	//public  LogoutPage logoutpage;
	//public  AboutMePage aboutmepage;

	@BeforeTest
	//@Test(priority=1)
public void setUp() {
		
		Properties prop= init_properties(IConstants.TEST_CONFIG_PATH);	
		invokeBrowser(prop.getProperty("BrowserName"));
		invokeApplicationURL(prop.getProperty("url"));
		
		
		
	}
	
	@AfterTest
	public void logout() {
		//extent.flush();
		//driver.quit();
	
	}
}
