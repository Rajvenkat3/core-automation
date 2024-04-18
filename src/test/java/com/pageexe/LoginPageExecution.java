 package com.pageexe;

import com.locator.LoginPageLocators;

public class LoginPageExecution extends LoginPageLocators {
	
	public static void username(String uname) {
	typedata(new LoginPageLocators().getUsername(),uname);
		
	}
	
	public static void password(String pwd) {
		typedata(new LoginPageLocators().getPassword(),pwd);
	}
	
	public  static void login() {
	clickopt(new LoginPageLocators().getLogin());
		
	}
	
	public void print() {
		System.out.println("Sucess");
		
	}

	
}
