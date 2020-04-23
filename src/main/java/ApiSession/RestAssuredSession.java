package ApiSession;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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
        Response response = getResponse(api,requestSpecification);
        System.out.println(response.body().prettyPrint());
    }

    public Response getResponse(Api api,RequestSpecification requestSpecification){
        Response response = null;
        String httpMethod = api.getHttpMethod();
        String path = api.getPath();
        switch (httpMethod)
        {
            case "GET":
                response = requestSpecification.get(path);
                break;
            case "POST":
                response = requestSpecification.post(path);
                break;
            case "PUT":
                response = requestSpecification.put(path);
                break;
            case "PATCH":
                response = requestSpecification.patch(path);
                break;
        }
        return response;
    }

    public void setHttpHeaders(Api api,RequestSpecification requestSpecification){
        requestSpecification.headers(api.getHeaders());
    }

    public void setIfQueryParamAvailable(Api api,RequestSpecification requestSpecification){
        if(api.getQueryParams()!=null){
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