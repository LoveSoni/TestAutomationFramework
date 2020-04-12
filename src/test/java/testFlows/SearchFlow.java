package testFlows;

import org.apache.log4j.Logger;
import sessions.SessionManager;
import testSteps.AppPageSteps;
import testSteps.MainPageSteps;
import testSteps.SearchSteps;

public class SearchFlow {
    private SearchSteps searchSteps;
    private MainPageSteps mainPageSteps;
    private AppPageSteps appPageSteps;
    private Logger logger = Logger.getLogger(SearchFlow.class);

    public SearchFlow(SessionManager sessionManager){
        searchSteps = new SearchSteps(sessionManager);
        appPageSteps = new AppPageSteps(sessionManager);
        mainPageSteps = new MainPageSteps(sessionManager);
    }

    public void selectInvokeSearch(){
        moveToSearchoptions();
        logger.info("Select Invoke Search ");
        searchSteps.selectInvokeSearch();
    }

    public void selectQuerySearchResult(){
        moveToSearchoptions();
        logger.info("Search Query Search Result");
        searchSteps.selectQuerySearhResults();
    }

    public void moveToSearchoptions(){
        logger.info("Select App option from Main Page");
        mainPageSteps.selectAppOption();
        logger.info("Select Search Option ");
        appPageSteps.selectSearch();
    }
}
