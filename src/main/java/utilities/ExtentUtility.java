package utilities;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import constants.Constants;

public class ExtentUtility {

    public void createInstance(){
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(Constants.EXTENT_REPORT_PATH);

    }

}
