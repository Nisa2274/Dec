package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	//create locators- BY
	
	By emailid =By.id("username");
	By password = By.id("password");
	By loginButton =By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//constructor of the classpage
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
     // page actions
	
	public String getPageTitle(){
		 return driver.getTitle();
	}
	
	public boolean checkSignUpLink(){
		 return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String username, String pwd ){
		driver.findElement(emailid).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		 //return  HomePage();
	}
}

