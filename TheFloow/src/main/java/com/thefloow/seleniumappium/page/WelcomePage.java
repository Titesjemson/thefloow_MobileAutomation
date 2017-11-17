/**
 * @class_Description: This class contains the page objects of Welcome Page
 * @created_on: 11/11/2017
 * @lastEdited_on: 11/16/2017
 * @lastEdited_by: Jemson 
 */
package com.thefloow.seleniumappium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.thefloow.seleniumappium.common.Common;
import com.thefloow.seleniumappium.extentreport.ReportGenerator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Administrator
 *
 */
public class WelcomePage {
	
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_welcome_close")
	 public WebElement close_btn;
	
	//Welcome to FlowDrive
	
	//What do I need to do next?
	
	//Need help with anything else?
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_welcome_start")
	 public WebElement startnow_btn;
	
	@FindBy(how = How.ID, using = "android:id/button1")
	 public WebElement ok_btn;
	
	//To verify Welcome page and click start button
	 public static void verifyandclosingWelcomepageAction(AndroidDriver<MobileElement> driver, ReportGenerator generator) throws Exception {
		  try{
		    	
				 WelcomePage wpobj=  PageFactory.initElements(driver,WelcomePage.class);
				 generator.childReport("Swiped and Verified the 1 Welcome window Text");
				 Common.checkAppElementPresent(driver, "Welcome to FlowDrive");
				 generator.childReport("Swiped and Verified the 2 Welcome window Text");
				 Common.swipeRighttoLeft(driver);
				 Common.checkAppElementPresent(driver, "What do I need to do next?");
				 generator.childReport("Swiped and Verified the 3 Welcome window Text");
				 Common.swipeRighttoLeft(driver);
				 Common.checkAppElementPresent(driver, "Need help with anything else?");				 
				 generator.childReport("Clicked Start Now button ");
				 wpobj.startnow_btn.click();			 
				 
				 generator.childReport("Clicked okay to Alert");
				 wpobj.ok_btn.click();
				
		   	}
			 catch(Exception ex){
				 throw ex;
			}
		    	 
	    }
	
	
	
	

}
