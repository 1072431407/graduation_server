package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.Absentee;
import com.drivinggrpc.driving.po.Graduate;
import com.drivinggrpc.driving.po.UserApply;

import java.util.List;

public interface StudentAdminServer {
    List<UserApply> getUserApplys();

    void consentApply(String user_id);

    void refuseApply(String user_id);

    List<UserApply> getUserAbsenteeAll();

    UserApply getUserApplyMessage(String user_id);

    Absentee getUserAbsentee(String user_id);

    void block(String user_id);

    List<Graduate> getGraduateAll();

    void removeGraduate(String user_id);

    List<Graduate> getBlackListAll();

}
