package majors.openSource.youbanWithHttp;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import java.util.HashMap;
import java.util.Map;

public class AudioHttp {
    Map<String, String> map = new HashMap<>();

    public static String createGetRequest(String url) {
        ClientConfig cc = new DefaultClientConfig();
        Client client = Client.create(cc);
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.get(ClientResponse.class);
        String s = response.getEntity(String.class);
        return s;

    }

    public static String createGetRequestAddParam(String url, Map<String, String> map) {
        ClientConfig cc = new DefaultClientConfig();
        Client client = Client.create(cc);
        MultivaluedMap queryParams = new MultivaluedMapImpl();
        map.forEach((k, v) -> {
            queryParams.add(k, v);
        });
        WebResource webResource = client.resource(url);

        ClientResponse response = webResource.queryParams(queryParams).get(ClientResponse.class);
        int status = response.getStatus();
        String s = response.getEntity(String.class);
        return s;
    }


}
