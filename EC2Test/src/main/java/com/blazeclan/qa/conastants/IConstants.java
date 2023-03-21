package com.blazeclan.qa.conastants;

import java.util.Properties;

import com.blazeclan.qa.base.CommonFunctions;

public interface IConstants {
	
	Properties prop =CommonFunctions.init_properties("./src/test/resources/projectConfig.properties");
	String TEST_CONFIG_PATH=prop.getProperty("TestConfigPath");
	String EXTENT_CONFIG_PATH= prop.getProperty("ExtentConfigPath");

}
