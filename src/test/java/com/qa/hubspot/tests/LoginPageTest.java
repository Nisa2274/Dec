package com.qa.hubspot.tests;

import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.qa.hubspot.base.BasePage;

public class LoginPageTest {
	BasePage basePage;
	Properties prop;
	
	
	@BeforeTest 
	public void setUp(){
		basePage =new BasePage();
		prop = basePage.inti_properties();
		
		
		
	}

}
