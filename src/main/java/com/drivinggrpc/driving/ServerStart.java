package com.drivinggrpc.driving;

import com.drivinggrpc.driving.rpc.server.UserRpcServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerStart {
    private Server server;
    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8282)
                .addService(new UserRpcServer())
                .build()
                .start();
        System.out.println("Start gRPC Server ");
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Close JVM");
            ServerStart.this.stop();
        }));

    }

    private void stop() {
        if (null != this.server){
            this.server.shutdown();
        }
    }

    private void awaitTermination() throws InterruptedException{
        if (null != this.server){
            this.server.awaitTermination();
        }
    }
    public static void main(String[] args) throws IOException,InterruptedException{
        ServerStart server = new ServerStart();
        server.start();
        server.awaitTermination();
    }
}
