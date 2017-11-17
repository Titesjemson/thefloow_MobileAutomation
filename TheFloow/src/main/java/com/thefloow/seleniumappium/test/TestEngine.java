/**
 * @class_Description: This class designed to controls the entire test execution of the project
 * @created_on: 11/11/2017
 * @lastEdited_on: 11/16/2017
 * @lastEdited_by: Jemson 
 */
package com.thefloow.seleniumappium.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.thefloow.seleniumappium.common.Common;
import com.thefloow.seleniumappium.constant.Constant;
import com.thefloow.seleniumappium.excelutility.Excelutility;
import com.thefloow.seleniumappium.extentreport.ReportGenerator;
import com.thefloow.seleniumappium.page.HomePage;
import com.thefloow.seleniumappium.page.LoginPage;
import com.thefloow.seleniumappium.page.NewAccountCreation;
import com.thefloow.seleniumappium.page.TabNavigations;
import com.thefloow.seleniumappium.page.TermsandConditionsPage;
import com.thefloow.seleniumappium.page.WelcomePage;

import atu.testrecorder.ATUTestRecorder;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Jemson
 *
 */
public class TestEngine extends TabNavigations {
	
		AndroidDriver<MobileElement> driver;
		ReportGenerator reporter;
		DateFormat df;
		DateFormat dateFormat = new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");	
		ATUTestRecorder recorder;
	 

		@BeforeSuite
		public void beforeSuite() throws IOException{
			Excelutility.openStream();
		}
		@BeforeMethod		
		public void setup() throws Exception{
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/application");
			
			 recorder = new ATUTestRecorder(Constant.videoPath,Constant.videoFileName + dateFormat.format(new Date()), false); 
					
			File app = new File(appDir, "8b3d8e298a.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", "Y541-U02V100R001C583B106");
			capabilities.setCapability("platformVersion", "4.4.2");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", app.getAbsolutePath());			
			capabilities.setCapability("appPackage", "com.thefloow.flo");
			capabilities.setCapability("appActivity", "com.thefloow.flo.activity.LauncherActivity");
	 
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			//Thread.sleep(10000);
			//recorder.start();
		}
		
		/*This Test case is to create a new account, We purposively made it failed by changing Id of the
		  password. To demonstrate the how report is captured for failure scenario. Test data are utilized from excel.		   
		*/
		@Test(priority=1)	    
		public void newaccountCreation(Method method) throws Exception{
			 String methodName = method.getName(), tcName = "TC001";
			 reporter = new ReportGenerator(methodName);
			 TermsandConditionsPage.performIagreeAction(driver, reporter);
			 NewAccountCreation accobj=  PageFactory.initElements(driver,NewAccountCreation.class);
			 reporter.childReport("Account tab clicked");
			 accobj.newacc_link.click();	
			 reporter.childReport("Firstname Entered");
			 accobj.firstname_txtbx.sendKeys(Excelutility.readExcel(methodName,tcName,"FirstName"));
			 reporter.childReport("Surname Entered");
			 accobj.surname_txtbx.sendKeys(Excelutility.readExcel(methodName,tcName,"SurName"));
			 reporter.childReport("Email Entered");
			 accobj.email_txtbx.sendKeys(Excelutility.readExcel(methodName,tcName,"Email"));
			 reporter.childReport("Postcode Entered");
			 accobj.postcode_txtbx.sendKeys(Excelutility.readExcel(methodName,tcName,"Postcode"));			 
			 Common.verifyandHideKeybord(driver);
			 reporter.childReport("Company Name Entered");
			 accobj.companyname_txtbx.sendKeys(Excelutility.readExcel(methodName,tcName,"CompanyName"));	
			 reporter.childReport("DOB Entered");
			 accobj.dob_txtbx.click();
			 accobj.ok_btn.click();			 
			 Common.verifyandHideKeybord(driver);
			 reporter.childReport("Password Entered");
			 accobj.password_txtbx.sendKeys(Excelutility.readExcel(methodName,tcName,"ChoosePassword"));			 
			 Common.verifyandHideKeybord(driver);			 
			 reporter.childReport("RepeatPassword Entered");
			 accobj.confirmpassword_txtbx.sendKeys(Excelutility.readExcel(methodName,tcName,"RepeatPassword"));	 
			 reporter.childReport("Account submitted");
			 accobj.submit_btn.click();			 
		 }
		
		
		//This Test Case is to verify End to End flow of the Application
		@Test(priority=2)		
		public void verifyingEndtoEndFlow(Method method)throws Exception{
			String methodName = method.getName();
			reporter = new ReportGenerator( methodName);			
		    LoginPage.performLoginAction(driver, reporter);
		    WelcomePage.verifyandclosingWelcomepageAction(driver, reporter);
		    HomePage.verifyandStartJourneyAction(driver, reporter);
		    TabNavigations tnobj = PageFactory.initElements(driver,TabNavigations.class);
		    reporter.childReport("Journeys Tab Clicked");
		    tnobj.journeys_tab.click();
		    Common.checkAppElementPresent(driver, "No journeys to display.");
		    reporter.childReport("Score Tab Clicked");
		    tnobj.score_tab.click();		    
		    reporter.childReport("Social Tab Clicked");
		    tnobj.social_tab.click();
		    Common.checkAppElementPresent(driver, "Create a screen name.");
		    reporter.childReport("Help Tab Clicked");
		    tnobj.help_tab.click();
		    Common.checkAppElementPresent(driver, "Report a problem");
		    reporter.childReport("Home Tab Clicked");
		    tnobj.home_tab.click();
		    Common.back(driver);
		    reporter.childReport("Clicked Yes button");
		    tnobj.yes_btn.click();  
		    
		 }
		
		@AfterMethod		
		public void tearDown(ITestResult result) throws Exception{
			 String methodName=result.getMethod().getMethodName();
			 if(result.getStatus()==ITestResult.FAILURE){
				 String res=result.getThrowable().getMessage();
				 reporter.logScreenshot(driver, methodName,res);
			 }
			 reporter.endTest();
			 driver.quit();
			 
		}
		
		@AfterSuite
		public void afterSuite() throws IOException{
			reporter.flush();
			Excelutility.closeStream();			
		}
		
		

}
