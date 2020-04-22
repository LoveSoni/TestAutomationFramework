package ApiSession;

import java.util.Map;

public interface ApiManager {

    public void sendRequest(Api obj);

    public String getHttpMethod(Api api);

    public boolean isQueryParamsEnable(Api api);

    public boolean isRequestEnable(Api api);

}
