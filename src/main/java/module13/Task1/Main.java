package module13.Task1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        String uri1 = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request1 = HttpRequest.newBuilder(new URI(uri1))
                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                        "    \"id\": 11,\n" +
                        "    \"name\": \"Maksym Syvolapenko\",\n" +
                        "    \"username\": \"Antonette\",\n" +
                        "    \"email\": \"Shanna@melissa.tv\",\n" +
                        "    \"address\": {\n" +
                        "      \"street\": \"Victor Plains\",\n" +
                        "      \"suite\": \"Suite 879\",\n" +
                        "      \"city\": \"Wisokyburgh\",\n" +
                        "      \"zipcode\": \"90566-7771\",\n" +
                        "      \"geo\": {\n" +
                        "        \"lat\": \"-43.9509\",\n" +
                        "        \"lng\": \"-34.4618\"\n" +
                        "      }\n" +
                        "    },\n" +
                        "    \"phone\": \"010-692-6593 x09125\",\n" +
                        "    \"website\": \"anastasia.net\",\n" +
                        "    \"company\": {\n" +
                        "      \"name\": \"Deckow-Crist\",\n" +
                        "      \"catchPhrase\": \"Proactive didactic contingency\",\n" +
                        "      \"bs\": \"synergize scalable supply-chains\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  {"))
                .build();
        HttpResponse<String>response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
        System.out.println("Create new object - httpResponse.statusCode() = " + response1.statusCode());
        System.out.println("Create new object - httpResponse.body() = " + response1.body());

        String uri2 = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request2 = HttpRequest.newBuilder(new URI(uri2))
                .GET()
                .build();
        HttpResponse<String>response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());
        System.out.println("Update - httpResponse.statusCode() = " + response1.statusCode());
        System.out.println("Update - httpResponse.body() = " + response1.body());

        String uri3 = "https://jsonplaceholder.typicode.com/users/3";
        HttpRequest request3 = HttpRequest.newBuilder(new URI(uri3))
                .DELETE()
                .build();
        HttpResponse<String>response3 = client.send(request3, HttpResponse.BodyHandlers.ofString());
        System.out.println("Delete - httpResponse.statusCode() = " + response3.statusCode());

        String uri4 = "https://jsonplaceholder.typicode.com/users/5";
        HttpRequest request4 = HttpRequest.newBuilder(new URI(uri4))
                .GET()
                .build();
        HttpResponse<String>response4 = client.send(request4, HttpResponse.BodyHandlers.ofString());
        System.out.println("Receive response from id - httpResponse.statusCode() = " + response4.statusCode());
        System.out.println("Receive response from id - httpResponse.body() = " + response4.body());

        String uri5 = "https://jsonplaceholder.typicode.com/users?username=Karianne";
        HttpRequest request5 = HttpRequest.newBuilder(new URI(uri5))
                .GET()
                .build();

        HttpResponse<String>response5 = client.send(request5, HttpResponse.BodyHandlers.ofString());
        System.out.println("Receive response from username - httpResponse.statusCode() = " + response5.statusCode());
        System.out.println("Receive response from username - httpResponse.body() = " + response5.body());
    }
}
