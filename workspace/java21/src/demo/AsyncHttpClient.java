package demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncHttpClient {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                .GET().
                build();

        CompletableFuture<HttpResponse<String>> responseCompletableFuture =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        // continue with other tasks, non-blocking

        System.out.println("Request Sent...");

        try {
            System.out.println(responseCompletableFuture.join().body()); //blocking
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
