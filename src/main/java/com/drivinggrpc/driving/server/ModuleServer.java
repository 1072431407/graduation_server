package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.UserApply;
import com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse;

public interface ModuleServer {
    String userApply(UserApply userApply,String date);

    String getApplyStateByUserId(int userId);
}
