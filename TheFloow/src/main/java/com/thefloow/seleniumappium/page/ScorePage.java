/**
 * @class_Description: This class contains the page objects of Score Page
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
public class ScorePage {
	
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_component_score")
	 public WebElement componentscore_btn;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_score_information")
	 public WebElement scoreinfo_btn;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_weekly")
	 public WebElement weekly_btn;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_monthly")
	 public WebElement monthly_btn;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_backward")
	 public WebElement backward_btn;
	 
	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_forward")
	 public WebElement forward_btn;
	 
	 //NO HISTORICAL SCORE DATA AVAILABLE AT THIS TIME.

}
