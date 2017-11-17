/**
 * @class_Description: This class contains the page objects of Forget Password Page 
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
public class ForgetPasswordPage {
	
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/edit_text_email")
	 public WebElement email_txtbx;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_get_code")
	 public WebElement send_btn;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/layout_got_code")
	 public WebElement haveacode_btn;
	 

}
