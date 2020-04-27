package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;
	
	By header = By.cssSelector("hi.private-page__title");
	By accountName = By.cssSelector("span.account-name");
	
	public HomePage(WebDriver driver){
		this.driver= driver;
			
	}
	public String getHomepageTitle(){
		return driver.getTitle();
		
	}
		
	
	public String getHomepageHeader(){
		return driver.findElement(header).getText();
		
	}
	
	public void getLoggedInUserAccountName(){
		driver.findElement(accountName).getText();
		}
	

}
