/**
 * @class_Description: This class common methods to support across the project
 * @created_on: 11/10/2017
 * @lastEdited_on: 11/16/2017
 * @lastEdited_by: Jemson
 */
package com.thefloow.seleniumappium.common;


import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * @author Jemson
 *
 */
public class Common {
	//This Method is used to Hide the Keyboard
	public static void verifyandHideKeybord(AndroidDriver<MobileElement> driver)	
	{
	try {
        driver.hideKeyboard();
        } catch (Exception e) {
        }
	}
	
	//This method is used to verify the text present in the page
	public static void checkAppElementPresent(AndroidDriver<MobileElement> driver, String expectedstring) {
		  //There is element with name App on screen.
		  //So iselementpresent will be set to true.
		  Boolean iselementpresent = driver.findElementsByName(expectedstring).size() != 0;
		  //iselementpresent will be true so assertion will pass and so test method will pass too.
		  Assert.assertTrue(iselementpresent,"Targeted element "+expectedstring+" is not present on screen");	 
	 }
	
	//This method is used to navigate back
	public static void back(AndroidDriver<MobileElement> driver) {
	
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
	        } catch (Exception e) {
	        }
	}
	
	//This method is used to Swipe Right to Left
	public static void swipeRighttoLeft(AndroidDriver<MobileElement> driver){		
			Dimension d =driver.manage().window().getSize();
		  int y = d.height/2;
		  int endX = d.width/4;
		  int startX = endX * 3;
		  TouchAction action = new TouchAction((AndroidDriver<MobileElement>)driver); 
		  action.press(startX, y).waitAction(Duration.ofMillis(500)).moveTo(endX,y).release().perform();
		
	}
	

}
