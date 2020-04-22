package ApiSession;

/**
 * author Love
 */

import org.apache.log4j.Logger;

public class HttpSession implements ApiManager{
    private Logger logger = Logger.getLogger(HttpSession.class);

    public void sendRequest(Api api){

    }

    public String getHttpMethod(Api api){
        return "";
    }

    public boolean setIfQueryParamAvailable(Api api){
        return true;
    }

    public boolean setIfRequestEnable(Api api){
        return true;
    }

}
