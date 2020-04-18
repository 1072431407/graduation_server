package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.Absentee;
import com.drivinggrpc.driving.po.UserApply;
import com.drivinggrpc.driving.po.UserStatistics;
import com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse;
import com.drivinggrpc.driving.rpc.proto.module.StatisticsDataRequest;

import java.util.List;

public interface ModuleServer {
    String userApply(UserApply userApply,String date);

    String getApplyStateByUserId(int userId);

    UserStatistics getStatisticsData(int userId);


}
