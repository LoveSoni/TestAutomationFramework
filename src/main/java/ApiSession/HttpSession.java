package ApiSession;

/**
 * author Love
 */

import org.apache.log4j.Logger;

public class HttpSession implements ApiManager{
    private Logger logger = Logger.getLogger(HttpSession.class);

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
