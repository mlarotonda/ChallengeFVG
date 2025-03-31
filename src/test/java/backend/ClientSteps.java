package backend;

import backend.client.Client;
import backend.client.GenericRequest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static backend.client.RequestMethods.GET;
import static backend.client.RequestMethods.POST;

public class ClientSteps extends Client {
    private String token;
    private String goRestUrl;

    public ClientSteps() {
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
            this.token = properties.getProperty("gorest.token");
            this.goRestUrl = properties.getProperty("gorest.url");
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo de propiedades", e);
        }
    }

    public GenericRequest getPostUserRequest(String randomEmail) {
        String requestBody = "{ " +
                "\"name\": \"Mauri\", " +
                "\"gender\": \"male\", " +
                "\"email\": \"" + randomEmail + "\", " +
                "\"status\": \"active\" " +
                "}";
        GenericRequest requestPostUser = new GenericRequest(goRestUrl, POST, requestBody);
        requestPostUser.setHeaderAuthorization(token);
        return requestPostUser;
    }

    public GenericRequest getGetUserRequest(int id) {
        GenericRequest requestGetUser = new GenericRequest(goRestUrl + "/" + id, GET);
        requestGetUser.setHeaderAuthorization(token);
        return requestGetUser;
    }

    public GenericRequest getGetUsersRequest() {
        GenericRequest requestGetUsers = new GenericRequest(goRestUrl, GET);
        requestGetUsers.setHeaderAuthorization(token);
        return requestGetUsers;
    }

}
