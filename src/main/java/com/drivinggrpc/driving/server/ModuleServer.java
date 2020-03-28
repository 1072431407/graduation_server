package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.UserApply;
import com.drivinggrpc.driving.po.UserStatistics;
import com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse;
import com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest;

import java.util.List;

public interface ModuleServer {
    String userApply(UserApply userApply,String date);

    String getApplyStateByUserId(int userId);

    UserStatistics getStatisticsData(int userId);

    List<UserApply> getUserApplys();

    void consentApply(int user_id);

    void refuseApply(int user_id);

    List<UserApply> getUserAbsentee();
}
