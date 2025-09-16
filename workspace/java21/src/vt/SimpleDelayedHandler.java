package vt;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class SimpleDelayedHandler implements HttpHandler {
    List<SimpleWork> workers = new ArrayList<>();
    int workersCount = 50;
    AtomicLong id = new AtomicLong();

    public SimpleDelayedHandler() {
        for(int i =0 ; i< workersCount; i++) {
            workers.add(new SimpleWork());
        }
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = null;
        response = workers.get((int)(id.incrementAndGet() % workersCount)).doJob();
        exchange.sendResponseHeaders(200, response.length());
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
