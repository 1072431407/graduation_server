package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.UserApply;
import com.drivinggrpc.driving.po.UserStatistics;
import com.drivinggrpc.driving.rpc.proto.module.*;
import com.drivinggrpc.driving.server.ModuleServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class ModuleController {
    private Logger logger = ApplicationTools.logger;
    @Autowired
    private ModuleServer moduleServer;

    /**
     * 用户报名
     * @param request
     * @param picture
     * @return
     */
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
        logger.info("userApply:userId="+request.getUserId()+"-->state="+state);
        return response;
    }

    /**
     * 返回用户当前进度
     * @param userId
     * @return
     */
    public ApplyStateResponse getApplyState(int userId) {
        ApplyStateResponse response = ApplyStateResponse.newBuilder().setState(moduleServer.getApplyStateByUserId(userId)).build();
        logger.info("getApplyState:userId="+userId+"-->state="+response.getState());
        return response;
    }

    /**
     * 返回用户科目一、四统计数据
     * @param request
     * @return
     */
    public StatisticsDataResponse getStatisticsData(StatisticsDataRequest request) {
        UserStatistics statistics = moduleServer.getStatisticsData(request.getUserId());
        StatisticsDataResponse response = null;
        if (request.getRequestType() == StatisticsDataRequest.REQUEST_TYPE.SUBJECT_1){
            response = StatisticsDataResponse.newBuilder()
                    .setNumQuestions(statistics.getNum_questions_1()+"")
                    .setAccuracy("正确率:"+statistics.getAccuracy_1()+"%")//正确率:50%
                    .setAverScore(statistics.getAver_score_1()+"")
                    .setDegree("累计考试次数:"+statistics.getDegree_1()+"次")//累计考试次数:5次
                    .build();
        }
        if (request.getRequestType() == StatisticsDataRequest.REQUEST_TYPE.SUBJECT_4){
            response = StatisticsDataResponse.newBuilder()
                    .setNumQuestions(statistics.getNum_questions_4()+"")
                    .setAccuracy("正确率:"+statistics.getAccuracy_4()+"%")//正确率:50%
                    .setAverScore(statistics.getAver_score_4()+"")
                    .setDegree("累计考试次数:"+statistics.getDegree_4()+"次")//累计考试次数:5次
                    .build();
        }
        logger.info("StatisticsDataResponse:userId="+request.getUserId()+",REQUEST_TYPE="+request.getRequestType());
        return response;
    }
}
