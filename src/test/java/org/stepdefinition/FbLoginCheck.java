package org.stepdefinition;

import com.pageexe.LoginPageExecution;

import io.cucumber.java.en.*;

public class FbLoginCheck extends LoginPageExecution {
	
	
	@Given("User Enters the URL")
	public void user_enters_the_url() throws InterruptedException {
		launchBrowser("webdriver.chrome.driver", "C:\\Users\\hp\\Documents\\chromedriver_win32\\chromedriver.exe");
		launchUrl("https://www.facebook.com/login.php");
		maxbrowser();
	}
	@When("User enters the username {string}")
	public void user_enters_the_username(String string) {
		getUsername();
	}
	@When("User enters the password {string}")
	public void user_enters_the_password(String string) {
		getPassword();
	}
	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		login();
	}
	@Then("Validate the home pages title")
	public void validate_the_home_pages_title() {

	}



	

}
