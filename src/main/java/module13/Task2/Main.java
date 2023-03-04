package module13.Task2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users/1/posts";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("response.statusCode() = " + response.statusCode());
//        System.out.println("response.body() = " + response.body());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Post> posts = objectMapper.readValue(response.body(), new TypeReference<>() {
        });

        Optional<Integer> max = posts.stream()
                .map(Post::getId)
                .max(Integer::compareTo);

        String URL = "https://jsonplaceholder.typicode.com/posts/".concat(max.get().toString()).concat("/comments");
        HttpRequest secondRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET()
                .build();

        HttpResponse<String> secondResponse =
                client.send(secondRequest, HttpResponse.BodyHandlers.ofString());

        //Deserialization response body to comments list
        List<Comment> comments = objectMapper.readValue(secondResponse.body(), new TypeReference<>() {
        });

        List<String> strings = comments.stream()
                .map(Comment::getBody)
                .toList();

        System.out.println(strings);
    }
}