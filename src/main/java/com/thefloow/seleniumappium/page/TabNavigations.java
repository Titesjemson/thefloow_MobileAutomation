/**
 * @class_Description: This class contains the page objects of Tabs Navigation
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
public class TabNavigations {
	
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/tab_home")
	 public WebElement home_tab;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/tab_journeys")
	 public WebElement journeys_tab;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/tab_score")
	 public WebElement score_tab;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/tab_social")
	 public WebElement social_tab;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/tab_help")
	 public WebElement help_tab;
	 
	 @FindBy(how = How.ID, using = "android:id/button1")
	 public WebElement yes_btn;
	 
	 @FindBy(how = How.ID, using = "android:id/button2")
	 public WebElement cancle_btn;
	 
	 
	 
	 
}
