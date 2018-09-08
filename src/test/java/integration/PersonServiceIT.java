package integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import cn.huang.test.utilities.RestTestUtilities;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.io.Files;
import com.google.gson.Gson;

import cn.huang.dropwizardstudy.data.Person;
import integration.supporting.Auth;

/**
 * Unit test for simple App.
 */
public class PersonServiceIT {
    private static Client client;
    private static String token;
    private static final String TEST_AUTH_USER_NAME = "rmsdmuser";
    private static final String TEST_AUTH_TENANT = "rms";
    private static final String TEST_AUTH_PASSWORD = "P@ssword1";

    /*
        Prepare the client and token for tests
     */
    @BeforeClass
    public static void setupTest() {
//        token = new Auth(
//                TEST_AUTH_USER_NAME,
//                TEST_AUTH_TENANT,
//                TEST_AUTH_PASSWORD).getBearerToken();

        JacksonJsonProvider jacksonJsonProvider = new JacksonJaxbJsonProvider();
        jacksonJsonProvider.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        client = ClientBuilder.newClient().register(jacksonJsonProvider);
    }

    @AfterClass
    public static void tearDown() {
        if (client != null) {
            client.close();
        }
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldGetAllPerson() throws Exception {
        Response response = client.target("http://localhost:8888/person/all")
                .request(MediaType.APPLICATION_JSON)
//                .header("Authorization", token)
                .get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        String actualOutput = response.readEntity(String.class);
        assertNotNull(actualOutput);
        String expectedOutput = RestTestUtilities.readPayloadsFromResource("all-person.response.json");
        assertTrue(assertResponseJson(expectedOutput, actualOutput));
    }

    @Test
    public void shouldCreatePerson() throws Exception {
        String request = RestTestUtilities.readPayloadsFromResource("1.create-person.request.json");
        Response response = client.target("http://localhost:8888/person/save")
                .request(MediaType.APPLICATION_JSON)
//                .header("Authorization", token)
                .post(Entity.json(request));

        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        String actualOutput = response.readEntity(String.class);
        assertNotNull(actualOutput);
        String expectedOutput = RestTestUtilities.readPayloadsFromResource("1.create-person.response.json");
        assertTrue(assertResponseJson(expectedOutput, actualOutput));
    }

    private Person deserializeResponse(String responseBody) {
        Gson gson = new Gson();
        return gson.fromJson(responseBody, Person.class);
    }

    private boolean assertResponseJson(String expected, String actual) {
        Person expectedOutputLocations = deserializeResponse(expected);
        Person actualOutputLocations = deserializeResponse(actual);
        return expectedOutputLocations.equals(actualOutputLocations);
    }
}
