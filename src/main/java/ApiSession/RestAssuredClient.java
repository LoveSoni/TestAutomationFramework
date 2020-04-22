package ApiSession;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * author Love
 */

public class RestAssuredClient {
    private Logger logger = Logger.getLogger(RestAssuredClient.class);

    @Test
    public void getRequest(){
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification requestSpecification = RestAssured.given();
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("first_name","first");
        requestSpecification.queryParams(queryParams);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.get("public-api/users");
        logger.info("Status code is :"+response.statusCode());
        logger.info("Response is: "+response.getBody().asString());
    }

    @Test
    public void postRequest(){
        RestAssured.baseURI = "https://gorest.co.in";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gender","male");
        jsonObject.put("last_name","lastdfTime");
        jsonObject.put("first_name","firstdfTime");
        jsonObject.put("email","timssddffdfd@gmail.com");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonObject);
        Response response = requestSpecification.post("/public-api/users");
        System.out.print(response.getStatusCode());
        System.out.print(response.getBody().asString());
    }

}

