package com.locator;

import org.fb.base.BaseClasses;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPageLocators extends BaseClasses {
	
	public  LoginPageLocators() 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	
	
	public void setUsername(WebElement username) {
		this.username = username;
	}
	public void setPassword(WebElement password) {
		this.password = password;
	}
	public void setLogin(WebElement login) {
		this.login = login;
	}


	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(id="loginbutton")
	private WebElement login;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@FindBy(id="username")
//	private WebElement username;
//	
//	@FindBy(id="password")
//	private WebElement password;
//	
//	@FindBy(id="login")
//	private WebElement login;
//	
//	public WebElement getUsername() {
//		return username;
//	}
//	public void setUsername(WebElement username) {
//		this.username=username;
//	}
//	public WebElement getPassword() {
//		return password;
//	}
//	public void setPassword(WebElement password) {
//		this.password=password;
//	}
//	public WebElement getLogin() {
//		return login;
//	}
//	public void setLogin(WebElement login) {
//		this.login=login;
//	}
//	
//	
}
