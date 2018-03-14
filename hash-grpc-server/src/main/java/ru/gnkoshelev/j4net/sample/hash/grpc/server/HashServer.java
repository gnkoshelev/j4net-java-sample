package ru.gnkoshelev.j4net.sample.hash.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Created by kgn on 13.03.2018.
 */
public class HashServer {
    private final static int port = 7999;
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new HashServiceImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
        System.out.println("Server has been gracefully shutdown");
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final HashServer server = new HashServer();
        server.start();
        System.out.println("Server has been started");
        server.blockUntilShutdown();
    }
}
