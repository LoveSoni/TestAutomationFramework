package ApiSession;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

/**
 * author Love
 */

public class RestAssuredSession{
    private Logger logger = Logger.getLogger(RestAssuredSession.class);


    public void sendRequest(Api api){
        RestAssured.baseURI = api.getUrl();
        RequestSpecification requestSpecification = RestAssured.given();
        setIfQueryParamAvailable(api,requestSpecification);
        setHttpHeaders(api,requestSpecification);
        setIfRequestAvailable(api,requestSpecification);
    }

    public String getHttpMethod(Api api){
        return "";
    }

    public void setHttpHeaders(Api api,RequestSpecification requestSpecification){
        requestSpecification.headers(api.getHeaders());
    }

    public void setIfQueryParamAvailable(Api api,RequestSpecification requestSpecification){
        if(!api.getQueryParams().isEmpty()){
            requestSpecification.queryParams(api.getQueryParams());
        }
    }

    public void setIfRequestAvailable(Api api,RequestSpecification requestSpecification){
        JSONObject requestJson = api.getRequestJson();
        if(!requestJson.isEmpty()){
            requestSpecification.body(requestJson);
        }
    }

}