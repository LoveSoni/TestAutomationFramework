package testClasses;

/**
 * author Love
 */

import base.BaseClass;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testFlows.SearchFlow;
import utilities.LogUtility;

public class SearchTest extends BaseClass {
    /**
     * This class should contains all the assertions
     */
    private SearchFlow searchFlow;
    private LogUtility logger = new LogUtility(SearchTest.class);

    @BeforeMethod
    public void intialize() {
        searchFlow = new SearchFlow(sessionManager);
    }

    @Test
    public void verifyUserIsOnInvokeSearchScreen() {
        searchFlow.selectInvokeSearch();
        logger.logInfo("Verify User is on Invoke Search Screen or not");
        Assert.assertTrue(searchFlow.isSearchRequestedDisplay());
    }

    @Test
    public void validateTheSearchText() {
        String prefilQuery = "test1";
        String appData = "test2";
        searchFlow.selectInvokeSearch();
        logger.logInfo("Validate the search text");
        searchFlow.enterPrefilQueryAndAppData(prefilQuery, appData);
        String actualResult = searchFlow.clickOnRequestedAndGetSearchText();
        logger.logInfo("Now verify that search text and prefill text should be same");
        Assert.assertEquals(actualResult, prefilQuery); // prefilQuery is the expected result
    }


    @Test
    public void verifyUserIsOnQuerySearchResult() {
        searchFlow.selectQuerySearchResult();
        String expectedResult = "App/Search/Query Search Results";
        logger.logInfo("Expected Query Search Title -" + expectedResult);
        String actualResult = searchFlow.fetchQueryTitle();
        logger.logInfo("Actual Query Search Title -" + actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    /**
     * Negative cases
     * 1. Only enter prefilquery and then verify the search result
     * 2. Leave prefil query as blank and verify search result should also be blank
     */


    @Test
    public void onlyEnterPrefilQueryAndVerifySearchResult() {
        String prefixText = "mylo";
        searchFlow.selectInvokeSearch();
        searchFlow.enterOnlyPrefilQuery(prefixText);
        String actualResult = searchFlow.clickOnRequestedAndGetSearchText();
        Assert.assertEquals(prefixText, actualResult);
    }
}
