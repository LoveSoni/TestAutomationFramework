package testClasses;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testFlows.SearchFlow;

public class SearchTest extends BaseClass {
    /**
     * This class should contains all the assertions
     */
    private SearchFlow searchFlow;
    private Logger logger = Logger.getLogger(SearchTest.class);

    @BeforeMethod
    public void intialize(){
        searchFlow = new SearchFlow(sessionManager);
    }

    @Test
    public void verifyUserIsOnInvokeSearchScreen(){
        searchFlow.selectInvokeSearch();
        logger.info("Verify User is on Invoke Search Screen or not");
        Assert.assertTrue(searchFlow.isSearchRequestedDisplay());
    }

    @Test
    public void validateTheSearchText(){
        String prefilQuery = "test1";
        String appData = "test2";
        searchFlow.selectInvokeSearch();
        logger.info("Validate the search text");
        searchFlow.enterPrefilQueryAndAppData(prefilQuery,appData);
        String actualResult = searchFlow.clickOnRequestedAndGetSearchText();
        logger.info("Now verify that search text and prefill text should be same");
        Assert.assertEquals(actualResult , prefilQuery); // prefilQuery is the expected result
    }



    @Test
    public void verifyUserIsOnQuerySearchResult(){
        searchFlow.selectQuerySearchResult();
        String expectedResult = "App/Search/Query Search Results";
        String actualResult = searchFlow.fetchQueryTitle();
        Assert.assertEquals(expectedResult,actualResult,"Query Search Title does not match");
    }

    @Test
    public void verifyTextAfterReclickOnSearchButton(){
        String expectedResult = "mylo";
        searchFlow.onSearchAndEnterText(expectedResult);
        logger.info("Verify that "+expectedResult +"should be display in search field");
        String actualResult = searchFlow.clickOnRequestedAndGetSearchText();
        // when the user click again on the requested search button after entering the value
        // enter text should be automatically removed
        Assert.assertEquals(expectedResult,actualResult);
    }

    /**
     * Negative cases
     * 1. Only enter prefilquery and then verify the search result
     * 2. Leave prefil query as blank and verify search result should also be blank
     */


    @Test
    public void onlyEnterPrefilQueryAndVerifySearchResult(){
        String prefixText = "mylo";
        searchFlow.enterOnlyPrefilQuery(prefixText);
        String actualResult = searchFlow.clickOnRequestedAndGetSearchText();
        Assert.assertEquals(prefixText,actualResult);
    }
}
