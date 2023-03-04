package module13.Task3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main3 {
    private static final String TEST_URL = "https://jsonplaceholder.typicode.com/users/1/todos";

    public static void main(String[] args) throws Exception {

        //Task #3
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(TEST_URL))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();

        List<Todo> todos = objectMapper.readValue(response.body(), new TypeReference<>() {
        });

        List<Todo> completedTodos = todos.stream()
                .filter(Todo::isCompleted)
                .toList();

        System.out.println(completedTodos);
    }
}
