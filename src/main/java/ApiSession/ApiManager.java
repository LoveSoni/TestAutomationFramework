package ApiSession;


public interface ApiManager {

    public void sendRequest(Api obj);

    public Object getHttpMethod(Api api);

    public boolean setIfQueryParamAvailable(Api api);

    public boolean setIfRequestEnable(Api api);

}
