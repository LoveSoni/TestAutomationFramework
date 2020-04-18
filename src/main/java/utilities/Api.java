package utilities;

import org.json.simple.JSONObject;
import java.util.Map;

public class Api {
    private String httpMethod;

    private String url;

    private Map<String, String> queryParams;

    private String path;

    public Api(String httpMethod, String url, String path, Map<String, String> headers) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.path = path;
        this.headers = headers;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public JSONObject getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(JSONObject requestJson) {
        this.requestJson = requestJson;
    }

    private Map<String, String> headers;

    private JSONObject requestJson;

}
