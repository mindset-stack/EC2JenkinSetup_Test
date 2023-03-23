/**
*
* @author Jay	
*/
package com.blazeclan.qa.test.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.blazeclan.qa.pages.LoginPage;
import com.blazeclan.qa.utility.TestListener;

@Listeners(TestListener.class)


public class LoginTest extends BaseTest {

	 /**
	* This is a class for login where base class is extended for driver and web elements are accessed
	* by using loginpage object
	    * @param args
	*/
	
	@Test(priority=1)
	public void LoginPage() throws InterruptedException {
		
		loginpage = new LoginPage(driver);
		enterText(loginpage.loginemail,"jamian.yovany@falltrack.net");
		enterText(loginpage.loginpassword,"Qwerty@123!");
		clickElement(loginpage.loginBtn);
		Thread.sleep(3000);
		String currentUrl= driver.getCurrentUrl();
		String actualUrl= "https://pulse-stage.projectai.com/app/help/how-to-use-pulse";
		Assert.assertEquals(actualUrl, currentUrl);
		Thread.sleep(5000);		
	}

}
