package testSteps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ElasticPush {
    public static void main(String args[]) {
        Map<String, Object> logs = new HashMap<>();
        Random random = new Random();
        RestAssured.baseURI = "http://localhost:9200/automation/result";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType("application/json");
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(100);
            String status = num % 2 == 0 ? "pass" : "fail";
            logs.put("testMethodName", "test case " + num);
            logs.put("status", status);
            logs.put("exception", "Exception on line number : " + num);
            logs.put("testSuite", "test suite " + num);
            logs.put("time", "2021-03-13T20:40:55.708Z");
            requestSpecification.body(logs);
            requestSpecification.log().all();
            Response response = requestSpecification.post();
            System.out.println(response.getStatusCode());
        }

    }
}
