package backend;

import backend.client.Client;
import backend.client.GenericRequest;
import backend.client.GenericResponse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class BackendTest extends Client {
    private final ClientSteps clientSteps;

    public BackendTest() {
        this.clientSteps = new ClientSteps();
    }

    @Test
    public void backend_casoDeUso1() {
        //Crear usuario con un email random, luego obtener usuario mediante el id creado y validar el email, por ultimo buscar el id en la lista de usuarios
        String randomEmail = String.format("challenge%s@f.com", System.currentTimeMillis());

        GenericRequest requestPostUser = clientSteps.getPostUserRequest(randomEmail);
        GenericResponse responsePostUser = sendRequest(requestPostUser);
        Assertions.assertEquals(201, responsePostUser.getStatusCode());
        int id = responsePostUser.getResponse().body().jsonPath().getInt("id");

        GenericRequest requestGetUser = clientSteps.getGetUserRequest(id);
        GenericResponse responseGetUser = sendRequest(requestGetUser);
        Assertions.assertEquals(200, responseGetUser.getStatusCode());
        Assertions.assertEquals(responseGetUser.getResponse().jsonPath().get("email"), randomEmail);

        GenericRequest requestGetUsers = clientSteps.getGetUsersRequest();
        GenericResponse responseGetUsers = sendRequest(requestGetUsers);
        Assertions.assertEquals(200, responseGetUsers.getStatusCode());
        List<Integer> userIds = responseGetUsers.getResponse().jsonPath().getList("id");
        Assertions.assertTrue(userIds.contains(id));
    }

}
