package ApiSession;

import org.apache.log4j.Logger;

/**
 * author Love
 */

public class RestAssuredSession implements ApiManager{
    private Logger logger = Logger.getLogger(RestAssuredSession.class);


    public void sendRequest(Api api){

    }

    public String getHttpMethod(){
        return "";
    }

    public boolean isQueryParamsEnable(){
        return true;
    }

    public boolean isRequestEnable(){
        return true;
    }
}

