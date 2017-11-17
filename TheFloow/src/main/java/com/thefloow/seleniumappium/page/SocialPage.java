/**
 * 
 */
package com.thefloow.seleniumappium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Administrator
 *
 */
public class SocialPage {
	
	@FindBy(how = How.ID, using = "com.thefloow.flo:id/social_screen_name")
	 public WebElement socialscreenname_txtbx;

	 @FindBy(how = How.ID, using = "com.thefloow.flo:id/btn_getting_started_next")
	 public WebElement next_btn;

	 //Create a screen name.

}
