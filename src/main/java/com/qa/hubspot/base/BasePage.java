package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	String path=null;
	String env= null;
	public static boolean highlighElment;
	
	public WebDriver init_driver(String browserName){
		highlighElment =prop.getProperty("highlight").equals("yes")?true:false;
		System.out.println("browser name"+browserName);
		
		if (browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	}
	
		else if (browserName.equals("safari")){
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
	}
		else{
			System.out.println("browser Name"+browserName+"is not found,please correct");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
		//driver.get(url);
		return driver;
	}

	//For giving a connection with config.properties
	
	public Properties inti_properties(){
		
		prop = new Properties();
		String path =". /src/main/java/com/qa/hubspot/confiq/config.properties";
		
		try{
			env = System.getProperty("env");
			if(env.equals("qa")){
				path=". /src/main/java/com/qa/hubspot/confiq/qa.config.properties";
			}else if (env.equals("stg")){
				path=". /src/main/java/com/qa/hubspot/confiq/stg.config.properties";
			}
			catch(Exception e){
				path=". /src/main/java/com/qa/hubspot/confiq/config.properties";
			}
			try {
				FileInputStream ip = new FileInputStream(path);
				try {
				prop.load(ip);
				} catch (IOException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			System.out.println("some issue with config properties... Please correct");
		}
		 return prop;
			
		
		
	
	
	
	
}