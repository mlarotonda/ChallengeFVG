package backend.client;

import java.util.HashMap;

public class GenericRequest {
    private String url;
    private Object body;
    private RequestMethods method;
    private HashMap<String, String> headers;

    public GenericRequest(String url, RequestMethods method) {
        setUrl(url);
        setMethod(method);
    }

    public GenericRequest(String url, RequestMethods method, Object body) {
        setUrl(url);
        setMethod(method);
        setBody(body);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public RequestMethods getMethod() {
        return this.method;
    }

    public void setMethod(RequestMethods method) {
        this.method = method;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeader(String headerName, String headerValue) {
        initHeaders();
        this.headers.put(headerName, headerValue);
    }

    private void initHeaders() {
        if (this.headers == null) {
            this.headers = new HashMap<>();
        }
    }

    public void setHeaderAuthorization(String token) {
        setHeader("Authorization", "Bearer " + token);
    }

}
