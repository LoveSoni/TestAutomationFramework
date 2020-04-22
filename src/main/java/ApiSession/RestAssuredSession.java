package ApiSession;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

/**
 * author Love
 */

public class RestAssuredSession implements ApiManager{
    private Logger logger = Logger.getLogger(RestAssuredSession.class);


    public void sendRequest(Api api){
        RestAssured.baseURI = api.getUrl();
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.headers(api.getHeaders());
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

