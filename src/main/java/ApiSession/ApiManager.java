package ApiSession;

import java.util.Map;

public interface ApiManager {

    public void sendRequest(Api obj);

    public String getHttpMethod();

    public boolean isQueryParamsEnable();

    public boolean isRequestEnable();

}
