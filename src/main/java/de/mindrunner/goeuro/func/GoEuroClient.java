package de.mindrunner.goeuro.func;

import de.mindrunner.goeuro.model.Position;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;

/**
 * @author Lukas Elsner <open@mindrunner.de>
 * @version 1.0
 * @since 13-05-2015
 * <p>
 * Simple wrapper around the GoEuro Rest API
 */
public class GoEuroClient {
    public static final String URI = "http://www.goeuro.com/GoEuroAPI/rest/api/v2/position/suggest/en/%s";
    private Client client;

    public GoEuroClient() {
        client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
    }

    /**
     * Querys the REST API endpoint
     *
     * @param query The search string
     * @return Array of Position objects, empty array if nothing was found
     */
    public Position[] getPositions(String query) {
        String uri = String.format(URI, query);
        Invocation.Builder builder = client.target(uri).request("application/json");
        return builder.get(Position[].class);
    }
}
