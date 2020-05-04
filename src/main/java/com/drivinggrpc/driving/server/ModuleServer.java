package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.*;
import com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse;
import com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest;

import java.util.List;

public interface ModuleServer {
    String userApply(UserApply userApply,String date);

    String getApplyStateByUserId(String userId);

    UserStatistics getStatisticsData(String userId);

    List<Exam> getExam(int state);

    String applyExam(String examId, String userId);

    List<Exam> getExercise(int state);

    String applyExercise(String examId, String userId);

    List<News> getNews(String userId);

    List<Bill> getBill(String userId);

    void readNews(int id);

    String billPay(int id);
}
