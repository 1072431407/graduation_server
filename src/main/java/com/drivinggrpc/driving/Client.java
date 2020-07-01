package com.drivinggrpc.driving;

import com.drivinggrpc.driving.rpc.proto.user.UserRpcServerGrpc;
import com.drivinggrpc.driving.rpc.proto.user.loginRequest;
import com.drivinggrpc.driving.rpc.proto.user.loginResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
//    public static void main(String[] args) {
//        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("192.168.3.36",8282)
//                .usePlaintext().build();
//        UserRpcServerGrpc.UserRpcServerBlockingStub stub = UserRpcServerGrpc.newBlockingStub(managedChannel);
//        loginRequest request = loginRequest.newBuilder()
//                .setUsername("15104343050")
//                .setPassword("111111")
//                .setPower(1)
//                .build();
////        System.out.println(Arrays.toString(request.getRequestBytes().toByteArray()));
//        loginResponse response = stub.login(request);
//        System.out.println(response.getState());
//    }

//    public static void main(String[] args) {
//        char[] strB;
//        char[] strA;
//        char[] strC;
//        List<Character> outStr = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//        strA = scanner.nextLine().toCharArray();
//        strB = scanner.nextLine().toCharArray();
//        strC = scanner.nextLine().toCharArray();
//        if (strA.length>strB.length)
//            for (char c:strB)
//                outStr.add(c);
//        for(int i = 0;i<strB.length;i++){
//            if (strA[0] == strB[i]){
//                boolean key = true;
//                for (int j = 1;j<strA.length;j++){
//                    if (i+j>=strB.length) {
//                        key = false;
//                        break;
//                    }
//                    if (strA[j] != strB[i+j]){
//                        key = false;
//                        break;
//                    }
//                }
//                if (key){//a ti huan wei c
//                    for (char bridgeC:strC)
//                        outStr.add(bridgeC);
//                    i+=strA.length-1;
//                }else
//                    outStr.add(strB[i]);
//
//            }else
//                outStr.add(strB[i]);
//        }
//
//        outStr.toArray();
//        System.out.println(new String(new char[outStr.size()]));
////        Scanner scanner = new Scanner(System.in);
////        double x1,y1,z1,x2,y2,z2;
////        x1 = scanner.nextDouble();
////        y1 = scanner.nextDouble();
////        z1 = scanner.nextDouble();
////
////        x2 = scanner.nextDouble();
////        y2 = scanner.nextDouble();
////        z2 = scanner.nextDouble();
////
////        //坐标偏移 将A点左边变成（0，0）
////        x2 = x2-x1;
////        y2 = y2-y1;
////        //平面内直角坐标系中坐标旋转变换公式
////        double x3 = x2*Math.cos(30)-y2*Math.sin(30)+x1;
////        double y3 = y2*Math.cos(30)+x2*Math.sin(30)+y1;
////
////        System.out.println("旋转后的B点坐标为:("+x3+","+y3+","+z2+")");
//
//    }
}
