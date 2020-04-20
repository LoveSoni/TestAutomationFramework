package utilities;

/**
 * author Love
 */

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    private Logger logger = Logger.getLogger(HttpClient.class);

    @Test
    public void getRequest(){
        String url =  "https://gorest.co.in";
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("first_name","first");
         url = buildUrlUsingParam(url,queryParams);
         logger.info("URL - "+url);
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
