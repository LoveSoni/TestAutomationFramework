package ApiSession;

/**
 * author Love
 */
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

public class HttpSession {
    private Logger logger = Logger.getLogger(HttpSession.class);

    public void sendRequest(Api api){
        CloseableHttpClient httpClient = HttpClients.createDefault();

    }

    public HttpRequestBase getHttpMethod(Api api){
        String httpMethod = api.getHttpMethod();
        HttpRequestBase httpRequestBase = null;
        switch (httpMethod){
            case "GET":
                httpRequestBase = new HttpGet();
                break;
            case "POST":
                httpRequestBase = new HttpPost();
                break;
            case "PUT":
                httpRequestBase = new HttpPut();
                break;
            case "PATCH":
                httpRequestBase = new HttpPatch();
                break;
        }
        return httpRequestBase;
    }

    public String setHttpHeaders(Api api){
        return "";
    }

    public boolean setIfQueryParamAvailable(Api api){
        return true;
    }

    public boolean setIfRequestEnable(Api api){
        return true;
    }

}
