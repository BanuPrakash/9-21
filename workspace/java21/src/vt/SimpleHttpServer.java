package vt;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SimpleHttpServer {
    public static void main(String[] args) throws Exception{
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8081), 0);
        httpServer.createContext("/example", new SimpleDelayedHandler());
        // platform threads
        httpServer.setExecutor(Executors.newFixedThreadPool(20));
//        httpServer.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        httpServer.start();
    }
}
