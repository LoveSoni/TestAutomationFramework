package ApiSession;

/**
 * author Love
 */
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HttpSession {
    private Logger logger = Logger.getLogger(HttpSession.class);

    public void sendRequest(Api api){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        api.setUrl(constructUrlWithQueryParam(api));
        HttpRequestBase httpRequestBase = getHttpMethod(api);
        setHttpHeaders(api,httpRequestBase);
        setIfRequestEnable(api,httpRequestBase);
    }

    public String constructUrlWithQueryParam(Api api){
        String url = api.getUrl()+api.getPath();
        Map<String,String> queryParams = api.getQueryParams();
        if(queryParams!=null) {
            try {
                URIBuilder uriBuilder = new URIBuilder(url);
                for (Map.Entry<String,String> map : queryParams.entrySet()) {
                    uriBuilder.addParameter(map.getKey(), map.getValue());
                }
                url = uriBuilder.build().toString();
            }catch (URISyntaxException exception)
            {
                logger.error(exception.getMessage());
            }
        }
        return url;
    }

    public HttpRequestBase getHttpMethod(Api api){
        String httpMethod = api.getHttpMethod();
        String url = api.getUrl();
        HttpRequestBase httpRequestBase = null;
        switch (httpMethod){
            case "GET":
                httpRequestBase = new HttpGet(url);
                break;
            case "POST":
                httpRequestBase = new HttpPost(url);
                break;
            case "PUT":
                httpRequestBase = new HttpPut(url);
                break;
            case "PATCH":
                httpRequestBase = new HttpPatch(url);
                break;
        }
        return httpRequestBase;
    }

    public void setHttpHeaders(Api api,HttpRequestBase httpRequestBase){
        Map<String,String> headers = api.getHeaders();
        for(Map.Entry<String,String> entry : headers.entrySet()){
            httpRequestBase.addHeader(entry.getKey(),entry.getValue());
        }
    }


    public void setIfRequestEnable(Api api,HttpRequestBase httpRequestBase){
        String request = api.getRequestJson().toString();
        StringEntity stringEntity = null;
        if(request!=null) {
            try {
                 stringEntity = new StringEntity(request);
            }catch (UnsupportedEncodingException e){
                logger.error(e.getMessage());
            }
            ((HttpEntityEnclosingRequestBase) httpRequestBase).setEntity(stringEntity);
        }
    }

    public static void main(String args[]) {
        Api api = new Api();
        api.setUrl("https://gorest.co.in");
        api.setPath("/public-api/users");
        api.setHttpMethod(Api.HttpMethod.POST);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gender","male");
        jsonObject.put("last_name","lastdfTime");
        jsonObject.put("first_name","firstdfTime");
        jsonObject.put("email","timssddffdfd@gmail.com");
        Map<String,String> map = new HashMap<>();
        map.put("Authorization","Bearer V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        api.setRequestJson(jsonObject);
        api.setHeaders(jsonObject);
        HttpSession httpSession = new HttpSession();
        httpSession.sendRequest(api);
    }

}
