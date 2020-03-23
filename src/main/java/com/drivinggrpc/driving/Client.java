package com.drivinggrpc.driving;

import com.drivinggrpc.driving.rpc.proto.user.UserRpcServerGrpc;
import com.drivinggrpc.driving.rpc.proto.user.loginRequest;
import com.drivinggrpc.driving.rpc.proto.user.loginResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("192.168.3.36",8282)
                .usePlaintext().build();
        UserRpcServerGrpc.UserRpcServerBlockingStub stub = UserRpcServerGrpc.newBlockingStub(managedChannel);
        loginRequest request = loginRequest.newBuilder()
                .setUsername("15104343050")
                .setPassword("111111")
                .setPower(1)
                .build();
//        System.out.println(Arrays.toString(request.getRequestBytes().toByteArray()));
        loginResponse response = stub.login(request);
        System.out.println(response.getState());
    }
}
