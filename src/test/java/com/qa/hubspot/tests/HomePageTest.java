package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;

public class HomePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeTest
	public void seUp(){
		basePage =new BasePage();
		prop = basePage.inti_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		 String title = homePage.getHomepageTitle();
		System.out.println("Title is :"+ title);
		Assert.assertEquals(title, "Reports dashboard");
	}
	@Test (priority=2)
	public void verifiHomePageHeaderTest(){
		 String header =homePage.getHomepageHeader();
	System.out.println("home page header is :"+ header);
	Assert.assertEquals(header, "Sales Dashboard");
	
	}
	//@Test(priority=3)
	//public void verifLoggedInUserTest(){
		//String  accountName = homePage.getLoggedInUserAccountName();
		//System.out.println("logged in account:"+ accountName);
		//Assert.assertEquals(accountName, "crmpro");
	
	
	
	
	
@AfterTest
public void tearDown(){
	driver.quit();
}
}
