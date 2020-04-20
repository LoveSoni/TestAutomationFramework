package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
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
        Response response = requestSpecification.post("public-api/users");
        logger.info("Status code is :"+response.statusCode());
        logger.info("Response is: "+response.getBody().asString());
    }

}

