package EC2JenkinSetup.EC2Test;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.blazeclan.qa.base.CommonFunctions;
import com.blazeclan.qa.conastants.IConstants;

public class BaseTest extends CommonFunctions {

	//@BeforeTest
	@Test(priority=1)
public void setUp() {
		
		Properties prop= init_properties(IConstants.TEST_CONFIG_PATH);	
		invokeBrowser(prop.getProperty("BrowserName"));
		invokeApplicationURL(prop.getProperty("url"));
		
		
		
	}
	
	@AfterTest
	public void logout() {
		//extent.flush();
		driver.quit();
	
	}
}
