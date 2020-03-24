package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.UserApply;
import com.drivinggrpc.driving.rpc.proto.module.ApplyRequest;
import com.drivinggrpc.driving.rpc.proto.module.ApplyResponse;
import com.drivinggrpc.driving.rpc.proto.module.ApplyStateResponse;
import com.drivinggrpc.driving.server.ModuleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ModuleController {
    @Autowired
    private ModuleServer moduleServer;

    public ApplyResponse userApply(ApplyRequest request,String picture){
        UserApply apply = new UserApply();
        apply.setUser_id(request.getUserId());
        apply.setPicture(picture);
        apply.setName(request.getName());
        apply.setSex(request.getSex());
        apply.setAge(request.getAge());
        apply.setAddress(request.getAddress());
        apply.setPhone(request.getPhone());
        apply.setOld_type(request.getOldType());
        apply.setType(request.getType());
        String state = moduleServer.userApply(apply,request.getDate());
        ApplyResponse response = ApplyResponse.newBuilder()
                .setState(state)
                .build();
        return response;
    }

    public ApplyStateResponse getApplyState(int userId) {
        ApplyStateResponse response = ApplyStateResponse.newBuilder().setState(moduleServer.getApplyStateByUserId(userId)).build();
        return response;
    }
}
