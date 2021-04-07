package ApiSession;

/**
 * author Love
 */

import org.json.simple.JSONObject;

import java.util.Map;

public class Api {

    public enum HttpMethod {
        GET, POST, PUT, PATCH;
    }

    public Api() {
        System.out.println("");
    }

    private String httpMethod;

    private String url;

    private String path;

    private Map<String, String> queryParams;

    private Map<String, String> headers;

    private JSONObject requestJson;

    private Map<String, String> multiPartRequest;

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

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setRequestJson(JSONObject requestJson) {
        this.requestJson = requestJson;
    }

    public JSONObject getRequestJson() {
        return requestJson;
    }

    public void setMultiPartRequest(Map<String, String> multiPartRequest) {
        this.multiPartRequest = multiPartRequest;
    }

    public Map<String, String> getMultiPartRequest() {
        return multiPartRequest;
    }

    
}
