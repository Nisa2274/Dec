package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElimentUtil {
	WebDriver driver;
	JavaScriptUtil jsUtil;
	
	
	public WebElement getElement(By locator){
		
		WebElement element = null;
		try{
			element= driver.findElement(locator);
			if(highlighElment){
				jsUtil.
			}
			
		}
		catch(){
	}
	

}
}