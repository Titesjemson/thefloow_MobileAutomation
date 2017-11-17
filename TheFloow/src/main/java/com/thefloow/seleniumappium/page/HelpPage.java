/**
 * @class_Description: This class contains page objects of Help Page
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
public class HelpPage {
	
	@FindBy(how = How.NAME, using = "FAQs")
	 public WebElement fags_btn;

	 @FindBy(how = How.NAME, using = "Preferences")
	 public WebElement preferences_btn;

	 @FindBy(how = How.NAME, using = "View messages")
	 public WebElement viewmsg_btn;
	 
	 @FindBy(how = How.NAME, using = "About")
	 public WebElement about_btn;
	 
	 @FindBy(how = How.NAME, using = "Report a problem")
	 public WebElement reportaprb_btn;
	 
	 //Report a problem
	 
	
}
