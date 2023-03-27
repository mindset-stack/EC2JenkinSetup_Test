package com.blazeclan.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//	@FindBy(xpath="//input[@name='username']")
//	public WebElement loginemail;
//	@FindBy(xpath="//input[@name='password']")
//	public WebElement loginpassword;
//	@FindBy(xpath="//button[normalize-space()='Sign In']")
//	public WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='coordinated_email']")
	public WebElement loginemail;
	@FindBy(xpath="//input[@id='coordinated_password']")
	public WebElement loginpassword;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement loginBtn;

	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
}
