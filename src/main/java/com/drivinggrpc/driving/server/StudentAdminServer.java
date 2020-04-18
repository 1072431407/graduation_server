package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.Absentee;
import com.drivinggrpc.driving.po.Graduate;
import com.drivinggrpc.driving.po.UserApply;

import java.util.List;

public interface StudentAdminServer {
    List<UserApply> getUserApplys();

    void consentApply(int user_id);

    void refuseApply(int user_id);

    List<UserApply> getUserAbsenteeAll();

    UserApply getUserApplyMessage(int user_id);

    Absentee getUserAbsentee(int user_id);

    void block(int user_id);

    List<Graduate> getGraduateAll();

    void removeGraduate(int user_id);

    List<Graduate> getBlackListAll();

}
