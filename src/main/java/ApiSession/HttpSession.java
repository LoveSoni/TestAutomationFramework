package ApiSession;

/**
 * author Love
 */
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.net.URISyntaxException;
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
        String url = api.getUrl();
        Map<String,String> queryParams = api.getQueryParams();
        if(!queryParams.isEmpty()) {
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
    }

}
