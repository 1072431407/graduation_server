package com.drivinggrpc.driving.rpc.server;

import com.drivinggrpc.driving.controller.StudyController;
import com.drivinggrpc.driving.rpc.proto.study.*;
import com.drivinggrpc.driving.tools.GrpcService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class StudyRpcServer extends StudyRpcServerGrpc.StudyRpcServerImplBase {
    @Autowired
    private StudyController controller;
    @Override
    public void getExam(GetExamRequest request, StreamObserver<GetTopicResponse> responseObserver) {
        List<GetTopicResponse> list = controller.getExam(request.getType());
        for (GetTopicResponse item:list)
            responseObserver.onNext(item);
        responseObserver.onCompleted();
    }

    @Override
    public void getTopic(GetTopicRequest request, StreamObserver<GetTopicResponse> responseObserver) {
        List<GetTopicResponse> list = controller.getTopic(request.getType(),request.getState());
        for (GetTopicResponse item:list)
            responseObserver.onNext(item);
        responseObserver.onCompleted();
    }

    @Override
    public void submitStatistics(SubmitStatisticsRequest request, StreamObserver<SubmitStatisticsResponse> responseObserver) {
        controller.submitStatistics(request.getNum(),request.getSum(),request.getType(),request.getLabel(),request.getUserId());
        responseObserver.onNext(SubmitStatisticsResponse.newBuilder().build());
        responseObserver.onCompleted();
    }
}
