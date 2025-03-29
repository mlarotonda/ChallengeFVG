package backend.client;

public enum RequestMethods {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE");

    private final String type;

    RequestMethods(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
