package backend;

import backend.client.Client;
import backend.client.GenericRequest;
import backend.client.GenericResponse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static backend.client.RequestMethods.GET;
import static backend.client.RequestMethods.POST;

public class BackendTest extends Client {
    private String token = "8be15159d6262598556ef7515d3cde415efd300fd426f6fdb0d5904ce93060ec";
    private String goRestUrl = "https://gorest.co.in/public/v2/users";

    @Test
    public void backend_casoDeUso1() {
        //Crear usuario con un email random, luego obtener usuario mediante el id creado y validar el email, por ultimo buscar el id en la lista de usuarios
        String randomEmail = String.format("challenge%s@f.com", System.currentTimeMillis());
        String requestBody = "{ " +
                "\"name\": \"Mauri\", " +
                "\"gender\": \"male\", " +
                "\"email\": \"" + randomEmail + "\", " +
                "\"status\": \"active\" " +
                "}";

        GenericRequest requestPostUser = new GenericRequest(goRestUrl, POST, requestBody);
        requestPostUser.setHeaderAuthorization(token);
        GenericResponse responsePostUser = sendRequest(requestPostUser);
        Assertions.assertEquals(201, responsePostUser.getStatusCode());
        int id = responsePostUser.getResponse().body().jsonPath().getInt("id");

        GenericRequest requestGetUser = new GenericRequest(goRestUrl + "/" + id, GET);
        requestGetUser.setHeaderAuthorization(token);
        GenericResponse responseGetUser = sendRequest(requestGetUser);
        Assertions.assertEquals(200, responseGetUser.getStatusCode());
        Assertions.assertEquals(responseGetUser.getResponse().jsonPath().get("email"), randomEmail);

        GenericRequest requestGetUsers = new GenericRequest(goRestUrl, GET);
        requestGetUsers.setHeaderAuthorization(token);
        GenericResponse responseGetUsers = sendRequest(requestGetUsers);
        Assertions.assertEquals(200, responseGetUsers.getStatusCode());
        List<Integer> userIds = responseGetUsers.getResponse().jsonPath().getList("id");
        Assertions.assertTrue(userIds.contains(id));
    }

}
