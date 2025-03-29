package backend.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;

import static backend.client.RequestMethods.*;
import static io.restassured.RestAssured.given;

public abstract class Client {

    protected RequestSpecification setBaseUriAs(String host) {
        return new RequestSpecBuilder()
                .setBaseUri(host)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    public GenericResponse sendRequest(GenericRequest request) {
        RequestSpecification requestSpecification = generateRequest(request);
        Response response = executeRequest(requestSpecification, request);
        return new GenericResponse(response);
    }

    private RequestSpecification generateRequest(GenericRequest request) {
        RequestSpecification requestSpecification = given()
                .spec(setBaseUriAs(request.getUrl())).urlEncodingEnabled(false);

        if (request.getHeaders() != null) {
            requestSpecification.headers(request.getHeaders());
        }
        if (request.getBody() != null && Arrays.asList(POST, PUT, PATCH).contains(request.getMethod())) {
            requestSpecification.body(request.getBody());
        }

        return requestSpecification;
    }

    private Response executeRequest(RequestSpecification requestSpecification, GenericRequest request) {
        requestSpecification.contentType(ContentType.JSON);
        Response response;
        try {
            response = requestSpecification.when().request(request.getMethod().getType());
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo ejecutar el request: " + e.getMessage());
        }
        return response;
    }

}
