/**
 * @class_Description: This class contains the page objects of Terms and Conditions Page
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
public class TermsandConditionsPage {
	
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_agree")
	 public WebElement iagree_btn;
	
	//To click I agree botton
	 public static void performIagreeAction(AndroidDriver<MobileElement> driver, ReportGenerator reporter) throws Exception {
		  try{
		    	
				 TermsandConditionsPage obj=  PageFactory.initElements(driver,TermsandConditionsPage.class);
				 Common.checkAppElementPresent(driver, "I Agree");
				 obj.iagree_btn.click();
				 reporter.childReport("Clicked I agree");
				 
		  }
			 catch(Exception ex){
				 throw ex;
			}
		    	 
	    }

}
