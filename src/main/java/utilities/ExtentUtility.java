package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class ExtentUtility {
    private ExtentHtmlReporter extentHtmlReporter;
    private ExtentReports extentReport;
    private ExtentTest extentTest;

    public ExtentUtility(){
        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator + "report.html");
        extentHtmlReporter.config().setReportName("Test Report");
        extentHtmlReporter.config().setDocumentTitle("Ebay");
        extentReport = new ExtentReports();
        extentReport.setSystemInfo("Developed by","name");
    }



}
