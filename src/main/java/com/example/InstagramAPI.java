import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class InstagramAPI {
    private final String accessToken;

    public InstagramAPI(String accessToken) {
        this.accessToken = accessToken;
    }

    public JsonNode getUserProfile() throws IOException {
        String url = "https://graph.instagram.com/me?fields=id,username&access_token=" + accessToken;
        return sendGetRequest(url);
    }

    public JsonNode getUserMedia() throws IOException {
        String url = "https://graph.instagram.com/me/media?fields=id,caption,username&access_token=" + accessToken;
        return sendGetRequest(url);
    }

    private JsonNode sendGetRequest(String url) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = client.execute(request);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(response.getEntity().getContent());
        }
    }
}
