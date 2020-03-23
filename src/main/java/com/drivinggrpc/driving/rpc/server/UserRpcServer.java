package com.drivinggrpc.driving.rpc.server;


import com.drivinggrpc.driving.controller.UserController;
import com.drivinggrpc.driving.rpc.proto.user.*;
import com.drivinggrpc.driving.tools.ApplicationTools;
import com.drivinggrpc.driving.tools.GrpcService;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@GrpcService
public class UserRpcServer extends UserRpcServerGrpc.UserRpcServerImplBase {
    @Autowired
    private UserController userController;
    @Override
    public void getUserMessageByUserName(getUserMessageRequest request, StreamObserver<getUserMessageResponse> responseObserver) {
        getUserMessageResponse response = userController.getUserMessageByUserName(request.getUserName());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void setUserMessage(setUserMessageRequest request, StreamObserver<setUserMessageResponse> responseObserver)  {
        File oldFile;
        File newFile = null;
        try {
            ByteString byteString = request.getHeadImage();
            byte[] bytes = byteString.toByteArray();
            newFile = new File(ApplicationTools.HEAD_IMAGE+request.getNewHeadImage()+".jpg");
            FileOutputStream outputStream = null;
            outputStream = new FileOutputStream(newFile);
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            outputStream.close();
            String oldFileString = request.getOldHeadImage();
            int start = oldFileString.lastIndexOf("/");
            oldFileString = oldFileString.substring(start+1);
            oldFile = new File(ApplicationTools.HEAD_IMAGE+oldFileString);
            oldFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
            if (newFile!=null && newFile.exists())
                newFile.delete();
            responseObserver.onCompleted();
            return;
        }
//        setUserMessageResponse response = setUserMessageResponse.newBuilder().setState("保存成功").build();
        setUserMessageResponse response = userController.setUserMessage(request,ApplicationTools.getHeadImage(request.getNewHeadImage()));
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void login(loginRequest request, StreamObserver<loginResponse> responseObserver) {
        loginResponse response = userController.userLogin(request.getUsername(),request.getPassword(),request.getPower());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void register(registerRequest request, StreamObserver<registerResponse> responseObserver) {
        registerResponse response = userController.userRegister(request.getUsername(),request.getPassword(),request.getPower());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void upPassword(upPasswordRequest request, StreamObserver<upPasswordResponse> responseObserver) {

        upPasswordResponse response = userController.upUserPassword(request.getUsername(),request.getPassword());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }



}
