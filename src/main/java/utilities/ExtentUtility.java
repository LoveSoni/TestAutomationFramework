package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import constants.Constants;
import constants.Defaults;

public class ExtentUtility {
    private static ExtentReports extentReports;

    public static void initializeReports() {
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(Constants.EXTENT_REPORT_PATH);
        extentHtmlReporter.config().setReportName(Defaults.EXTENT_REPORT_NAME);
        extentHtmlReporter.config().setDocumentTitle(Defaults.EXTENT_DOCUEMTN_TITILE);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    public ExtentReports getExtent() {
        return this.extentReports;
    }

    public void flushExtent() {
        extentReports.flush();
    }

}
