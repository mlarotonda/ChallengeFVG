package backend.client;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

public class GenericResponse {
    private int statusCode;
    private Object body;
    private HashMap<String, String> headers;
    private Response response;

    public GenericResponse(Response response) {
        setStatusCode(response.statusCode());
        setBody(response.getBody());
        setHeaders(response.getHeaders());
        setResponse(response);
    }

    public int getStatusCode() {
        return statusCode;
    }

    private void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    private void setBody(Object body) {
        this.body = body;
    }

    private void setHeaders(Headers headers) {
        HashMap<String, String> headersMap = new HashMap<>();
        List<Header> headerList = headers.asList();
        for (Header header : headerList) {
            headersMap.put(header.getName(), header.getValue());
        }
        this.headers = headersMap;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
