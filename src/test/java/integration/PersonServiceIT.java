package integration;

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

import static org.junit.Assert.*;

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

    @Test
    public void shouldGetAllPerson() throws Exception {
        Response response = client.target("http://localhost:8888/person/all")
                .request(MediaType.APPLICATION_JSON)
//                .header("Authorization", token)
                .get();

        // Has response
        assertNotNull(response);

        // Check response status
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        // Read response body
        String actualOutput = response.readEntity(String.class);
        assertNotNull(actualOutput);

        // Deserialize response and compare with test data
        Gson gson = new Gson();
        Person[] actualPersonArray = gson.fromJson(actualOutput, Person[].class);
        String expectedOutputJson = RestTestUtilities.readPayloadsFromResource("all-person.response.json");
        Person[] expectedPersonArray = gson.fromJson(expectedOutputJson, Person[].class);
        assertArrayEquals(expectedPersonArray, actualPersonArray);
    }

    @Test
    public void shouldCreatePerson() throws Exception {
        String request = RestTestUtilities.readPayloadsFromResource("create-person.request.json");
        Response response = client.target("http://localhost:8888/person/save")
                .request(MediaType.APPLICATION_JSON)
//                .header("Authorization", token)
                .post(Entity.json(request));

        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        String actualOutput = response.readEntity(String.class);
        assertNotNull(actualOutput);

        String expectedOutput = RestTestUtilities.readPayloadsFromResource("create-person.response.json");
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldGetPersonById() throws Exception {
        String request = RestTestUtilities.readPayloadsFromResource("create-person.request.json");
        Response response = client.target("http://localhost:8888/person/1")
                .request(MediaType.APPLICATION_JSON)
//                .header("Authorization", token)
                .get();

        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        String actualOutput = response.readEntity(String.class);
        assertNotNull(actualOutput);

        Gson gson = new Gson();
        Person actualPerson = gson.fromJson(actualOutput, Person.class);

        String expectedOutput = RestTestUtilities.readPayloadsFromResource("get-person-by-id.response.json");
        Person expectedPerson = gson.fromJson(expectedOutput, Person.class);

        assertEquals(actualPerson, expectedPerson);
    }
}
