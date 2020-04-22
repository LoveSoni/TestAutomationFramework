package ApiSession;


import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Api {

    public enum HttpMethod{
        GET,POST,PUT,DELETE;
    }

    public Api(){
    }

    private String httpMethod;

    private String url;

    private String path;

    private Map<String, String> queryParams;

    private Map<String, String> headers;

    private JSONObject requestJson;

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod.toString();
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getHeaders() { return headers; }

    public void setRequestJson(JSONObject requestJson) {
        this.requestJson = requestJson;
    }

    public JSONObject getRequestJson() {
        return requestJson;
    }

    public static void main(String args[]){
        Api api = new Api();
        api.setHttpMethod(HttpMethod.GET);
        api.setUrl("https://reqres.in");
        api.setPath("/api/users/2");
        Map<String,String> map = new HashMap<>();
        map.put("Content-Type","application/xml");
        api.setHeaders(map);
    }


}
