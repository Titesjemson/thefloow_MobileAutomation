/**
 * @class_Description: This class contains the page objects of Login Page
 * @created_on: 11/11/2017
 * @lastEdited_on: 11/16/2017
 * @lastEdited_by: Jemson 
 */
package com.thefloow.seleniumappium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.thefloow.seleniumappium.constant.Constant;
import com.thefloow.seleniumappium.extentreport.ReportGenerator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Jemson
 *
 */
public class LoginPage {
	
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_email")
	 public WebElement username_txtbx;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_password")
	 public WebElement password_txtbx;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_login")
	 public WebElement login_btn;
	 
	 //To perform login action
	 public static void performLoginAction(AndroidDriver<MobileElement> driver, ReportGenerator generator) throws Exception {
		  try{
		    	
				 LoginPage lpobj=  PageFactory.initElements(driver,LoginPage.class);
				 generator.childReport("Username entered");
				 lpobj.username_txtbx.sendKeys(Constant.appUsername);				 
				 generator.childReport("Password entered");					
				 lpobj.password_txtbx.sendKeys(Constant.appPassword);
				 generator.childReport("Login clicked");
				 lpobj.login_btn.click();
				 generator.childReport("Login verified");
				 
		   	}
			 catch(Exception ex){
				 throw ex;
			}
		    	 
	    }
	

}
