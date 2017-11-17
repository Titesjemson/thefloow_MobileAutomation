/**
 * @class_Description: This class is used to handles Sync of the ExtentReport
 * @created_on: 11/11/2017
 * @lastEdited_on: 11/16/2017
 * @lastEdited_by: Jemson
 */
package com.thefloow.seleniumappium.extentreport;


import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.thefloow.seleniumappium.constant.Constant;

/**
 * @author Jemson
 *
 */
public class ExtentReportFactory {
	
	private static ExtentReports reporter;
	 
    public static synchronized ExtentReports getReporter() {
           if (reporter == null) {
                  reporter = new ExtentReports(Constant.ReportPath, true, DisplayOrder.NEWEST_FIRST);
           }
           return reporter;
    }


}
