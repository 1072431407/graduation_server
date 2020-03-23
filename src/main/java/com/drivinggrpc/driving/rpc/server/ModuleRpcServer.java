package com.drivinggrpc.driving.rpc.server;

import com.drivinggrpc.driving.rpc.proto.module.*;
import com.drivinggrpc.driving.tools.GrpcService;
import io.grpc.stub.StreamObserver;

@GrpcService
public class ModuleRpcServer extends ModuleRpcServerGrpc.ModuleRpcServerImplBase {
    /**
     * 用户报名
     * @param request
     * @param responseObserver
     */
    @Override
    public void apply(ApplyRequest request, StreamObserver<ApplyResponse> responseObserver) {
        System.out.println(request.getUserId());
        ApplyResponse response = ApplyResponse.newBuilder()
                .setState("报名成功")//报名失败,请稍后重试
                .build();
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
        System.out.println(request.getUserId());
        ApplyStateResponse response = ApplyStateResponse.newBuilder().setState("科目一").build();
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
        if (StatisticsDataRequest.REQUEST_TYPE.SUBJECT_1 == request.getRequestType()){
            StatisticsDataResponse response = StatisticsDataResponse.newBuilder()
                    .setNumQuestions("100")
                    .setAccuracy("正确率:50%")
                    .setAverScore("25")
                    .setDegree("累计考试次数:5次")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }else{
            StatisticsDataResponse response = StatisticsDataResponse.newBuilder()
                    .setNumQuestions("1001")
                    .setAccuracy("正确率:80%")
                    .setAverScore("50")
                    .setDegree("累计考试次数:15次")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
