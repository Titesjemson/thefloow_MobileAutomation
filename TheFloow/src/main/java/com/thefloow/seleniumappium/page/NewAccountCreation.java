/**
 * @class_Description: This class contains the page objects of Account Creation Page
 * @created_on: 11/11/2017
 * @lastEdited_on: 11/16/2017
 * @lastEdited_by: Jemson 
 */
package com.thefloow.seleniumappium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Jemson
 *
 */
public class NewAccountCreation {	

	
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/text_view_create_account")
	 public WebElement newacc_link;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_first_name")
	 public WebElement firstname_txtbx;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_surname")
	 public WebElement surname_txtbx;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_date_of_birth")
	 public WebElement dob_txtbx;	 
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_email")
	 public WebElement email_txtbx;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_postcode")
	 public WebElement postcode_txtbx;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_company_name")
	 public WebElement companyname_txtbx;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_password")
	 public WebElement password_txtbx;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_confirm_password@")
	 public WebElement confirmpassword_txtbx;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/button_register")
	 public WebElement submit_btn;
	 
	 @FindBy(how = How.ID, using = "android:id/button1")
	 public WebElement ok_btn;
	 
	 

}
