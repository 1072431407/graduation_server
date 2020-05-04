package com.drivinggrpc.driving.rpc.server;

import com.drivinggrpc.driving.controller.ModuleController;
import com.drivinggrpc.driving.po.Exam;
import com.drivinggrpc.driving.rpc.proto.module.*;
import com.drivinggrpc.driving.tools.ApplicationTools;
import com.drivinggrpc.driving.tools.GrpcService;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
    }

    @Override
    public void applyExam(ApplyExamRequest request, StreamObserver<ApplyExamResponse> responseObserver) {
        ApplyExamResponse response = moduleController.applyExam(request.getExamId(),request.getUserId());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void applyExercise(ApplyExamRequest request, StreamObserver<ApplyExamResponse> responseObserver) {
        ApplyExamResponse response = moduleController.applyExercise(request.getExamId(),request.getUserId());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getExam(ExamRequest request, StreamObserver<ExamResponse> responseObserver) {
        List<ExamResponse> listBeans = moduleController.getExam(request.getState());
        for (ExamResponse item :listBeans)
            responseObserver.onNext(item);
        responseObserver.onCompleted();
    }

    @Override
    public void getExercise(ExamRequest request, StreamObserver<ExamResponse> responseObserver) {
        List<ExamResponse> listBeans = moduleController.getExercise(request.getState());
        for (ExamResponse item :listBeans)
            responseObserver.onNext(item);
        responseObserver.onCompleted();
    }

    @Override
    public void getNews(NewsRequest request, StreamObserver<NewsResponse> responseObserver) {
        List<NewsResponse> list = moduleController.getNews(request.getUserId());
        for (NewsResponse item :list)
            responseObserver.onNext(item);
        responseObserver.onCompleted();
    }

    @Override
    public void getBill(BillRequest request, StreamObserver<BillResponse> responseObserver) {
        List<BillResponse> list = moduleController.getBill(request.getUserId());
        for (BillResponse item :list)
            responseObserver.onNext(item);
        responseObserver.onCompleted();
    }

    @Override
    public void readNews(ReadNewsRequest request, StreamObserver<ReadNewsResponse> responseObserver) {
        moduleController.readNews(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void billPay(PayRequest request, StreamObserver<PayResponse> responseObserver) {
        PayResponse response = moduleController.billPay(request.getId());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
