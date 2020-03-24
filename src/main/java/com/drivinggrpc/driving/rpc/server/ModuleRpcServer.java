package com.drivinggrpc.driving.rpc.server;

import com.drivinggrpc.driving.controller.ModuleController;
import com.drivinggrpc.driving.rpc.proto.module.*;
import com.drivinggrpc.driving.tools.ApplicationTools;
import com.drivinggrpc.driving.tools.GrpcService;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@GrpcService
public class ModuleRpcServer extends ModuleRpcServerGrpc.ModuleRpcServerImplBase {
    @Autowired
    private ModuleController moduleController;
    /**
     * 用户报名
     * @param request
     * @param responseObserver
     */
    @Override
    public void apply(ApplyRequest request, StreamObserver<ApplyResponse> responseObserver) {
        File newFile = null;
        String pictureName = request.getDate()+"-"+request.getUserId()+"-picture.jpg";
        try {
            ByteString byteString = request.getPicture();
            byte[] bytes = byteString.toByteArray();
            newFile = new File(ApplicationTools.PICTURE_IMAGE+pictureName);
            FileOutputStream outputStream = new FileOutputStream(newFile);
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            if (newFile!=null && newFile.exists())
                newFile.delete();
            responseObserver.onCompleted();
            return;
        }
        ApplyResponse response = moduleController.userApply(request,pictureName);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 返回当前进度 独立表
     * @param request
     * @param responseObserver
     */
    @Override
    public void getApplyState(ApplyStateRequest request, StreamObserver<ApplyStateResponse> responseObserver) {
        ApplyStateResponse response = moduleController.getApplyState(request.getUserId());
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    /**
     * 获取统计数据
     * @param request
     * @param responseObserver
     */
    @Override
    public void getStatisticsData(StatisticsDataRequest request, StreamObserver<StatisticsDataResponse> responseObserver) {
        StatisticsDataResponse response = moduleController.getStatisticsData(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
//        if (StatisticsDataRequest.REQUEST_TYPE.SUBJECT_1 == request.getRequestType()){
//            StatisticsDataResponse response = StatisticsDataResponse.newBuilder()
//                    .setNumQuestions("100")
//                    .setAccuracy("正确率:50%")
//                    .setAverScore("25")
//                    .setDegree("累计考试次数:5次")
//                    .build();
//
//        }else{
//            StatisticsDataResponse response = StatisticsDataResponse.newBuilder()
//                    .setNumQuestions("1001")
//                    .setAccuracy("正确率:80%")
//                    .setAverScore("50")
//                    .setDegree("累计考试次数:15次")
//                    .build();
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//        }
    }
}
