package lk.ijse.weavybackend;

import okhttp3.*;
import java.io.IOException;

public class WeavyClient {
    private static final String BASE_URL = "https://8015b5dbc0724d38882ac90397c27649.weavy.io/api/users";
    private static final String API_TOKEN = "wys_hMWpXdekxcn9Gc8Ioah3azOllzUZ7l3HN9yB";
    private static final OkHttpClient client = new OkHttpClient();

    public static void createUser(String uid, String name) throws IOException {
        String json = "{\"uid\":\"" + uid + "\",\"name\":\"" + name + "\"}";
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_TOKEN)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        }
    }

    public static void main(String[] args) throws IOException {
        createUser("user123", "John Doe");
    }
}