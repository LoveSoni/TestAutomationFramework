package ApiSession;

/**
 * author Love
 */

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HttpSession {
    private Logger logger = Logger.getLogger(HttpSession.class);

    @Test
    public void getRequest(){
        HttpResponse httpResponse = null;
        String response = null;
        String url =  "https://gorest.co.in";
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("first_name","first");
        url = buildUrlUsingParam(url,queryParams);
        logger.info("URL - "+url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("content-type","application/json");
        try {
            httpResponse = httpClient.execute(httpGet);
        }catch (IOException e)
        {
            logger.error(e.getMessage());
        }
        logger.info("Status code - "+httpResponse.getStatusLine().getStatusCode());
        try {
            response = EntityUtils.toString(httpResponse.getEntity());
        }catch (IOException e)
        {
            logger.error(e.getMessage());
        }
        logger.info("Response - "+ response.toString());
    }

    public String buildUrlUsingParam(String url, Map<String,String> queryParams)
    {
        try {
        URIBuilder uriBuilder = new URIBuilder(url);
        uriBuilder.addParameter("first_name","first_name");
        url = uriBuilder.build().toString();
        }catch (URISyntaxException e){
            logger.error(e.getMessage());
        }
        return url;
    }
}
