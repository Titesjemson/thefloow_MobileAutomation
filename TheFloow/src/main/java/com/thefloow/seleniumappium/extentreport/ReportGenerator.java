/**
 * @class_Description: This class is to handles the methods to build the Extent Report
 * @created_on: 11/11/2017
 * @lastEdited_on: 11/16/2017
 * @lastEdited_by: Jemson
 */
package com.thefloow.seleniumappium.extentreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thefloow.seleniumappium.constant.Constant;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Jemson
 *
 */
public class ReportGenerator {
	ExtentTest childTest, parentTest;
	private static ExtentReports reporter = ExtentReportFactory.getReporter();

	public ReportGenerator (String methodName){
		parentReport(methodName);
	}
	
	public void parentReport(String methodName) {
		parentTest = reporter.startTest(methodName);
		parentTest.assignCategory("Android");
	
	}

	public void childReport(String methodName) {
		childTest = reporter.startTest(methodName);
		childTest.log(LogStatus.PASS, methodName);
		parentTest.appendChild(childTest);
	}

	public void flush(){
		reporter.flush();
	}
	public void endTest(){
		
		reporter.endTest(parentTest);
	}
	public void logScreenshot(AndroidDriver<MobileElement> driver, String methodname, String res) throws IOException{
		try{
			File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dir = new File(Constant.screenshotPath+methodname);
			dir.mkdirs();
			String workspace = 	((new File(".").getAbsolutePath()).replace("\\", "/")).replace(".", "");
			String fileName= workspace+Constant.screenshotPath+methodname+"/"+methodname+".jpg";
			FileUtils.copyFile(file, new File(fileName));
			ExtentTest logger = this.childTest;
			String img = logger.addScreenCapture(fileName);
		    logger.log(LogStatus.FAIL, "Image", res+img);
		}
		catch(Exception ex){
			System.out.println("Exception while taking screen  shot");
		}		
	}

}
