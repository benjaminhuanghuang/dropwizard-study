package integration.supporting;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;


public class Auth {

    private static final String AUTH_ENDPOINT_TYPE = "token/create";

    private String bearerToken;

    public Auth(String userName, String tenant, String password) {
        this.bearerToken = generateToken(userName, tenant, password);
    }

    public String getBearerToken() {
        return bearerToken;
    }

    private String generateToken(String userName, String tenant, String password) {
        HashMap<String, String> body = new HashMap<>();
        body.put("username", userName);
        body.put("tenant", tenant);
        body.put("password", password);

        String url = "https://one.dev.azure.rmsonecloud.net/" + AUTH_ENDPOINT_TYPE;

        Client client = ClientBuilder.newClient();
        client.register(JacksonJaxbJsonProvider.class);
        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(body));

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            // TODO: exception/log/return null?
            return null;
        }

        String output = response.readEntity(String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode json = objectMapper.readValue(output, JsonNode.class);
            return String.format("Bearer %s", json.get("token").asText());
        } catch (IOException e) {
            return null;
        }
    }
}
