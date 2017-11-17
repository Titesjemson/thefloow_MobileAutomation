/**
 * @class_Description: This class contains the page objects of Home Page
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
 * @author Jemson
 *
 */
public class HomePage {
	
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_emergency")
	 public WebElement emergency_btn;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_feedback")
	 public WebElement feedback_btn;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_start")
	 public WebElement startjourney_btn;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/chrono_duration")
	 public WebElement duration_label;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/text_view_mileage")
	 public WebElement distance_label;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/image_view_led")
	 public WebElement led_label;
	 
	 //Do not interact with the device while driving.
	 
	 //To verifing Home page and cliking start journey button
	 public static void verifyandStartJourneyAction(AndroidDriver<MobileElement> driver, ReportGenerator generator) throws Exception {
		  try{
		    	
				 HomePage hpobj=  PageFactory.initElements(driver,HomePage.class);
				 Common.checkAppElementPresent(driver, "Do not interact with the device while driving.");
				 generator.childReport("Clicked start Journey Button");
				 hpobj.startjourney_btn.click();				 
				 
		   	}
			 catch(Exception ex){
				 throw ex;
			}
		    	 
	    }
	 

}
