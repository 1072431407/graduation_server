package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.Absentee;
import com.drivinggrpc.driving.po.UserApply;
import com.drivinggrpc.driving.po.UserStatistics;
import com.drivinggrpc.driving.rpc.proto.module.*;
import com.drivinggrpc.driving.server.ModuleServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


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
        apply.setCode(request.getCode());
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

    /**
     * 初始化报名审批
     * @param model
     * @return
     */
    @GetMapping("/applyExamine")
    public String applyExamine(Model model){
        List<UserApply> userApplys = moduleServer.getUserApplys();
        model.addAttribute("userApplys",userApplys);
        logger.info("/applyExamine");
        return "list1_1";
    }

    /**
     * 同意报名
     * @param user_id
     * @param model
     * @return
     */
    @GetMapping("/applyExamine/consentApply")
    public String consentApply(@RequestParam(value = "user_id")int user_id,Model model){
        moduleServer.consentApply(user_id);
        logger.info("/applyExamine/consentApply:userId="+user_id);
        List<UserApply> userApplys = moduleServer.getUserApplys();
        model.addAttribute("userApplys",userApplys);
        return "list1_1::apply_list";
    }

    /**
     * 拒绝报名
     * @param user_id
     * @param model
     * @return
     */
    @GetMapping("/applyExamine/refuseApply")
    public String refuseApply(@RequestParam(value = "user_id")int user_id,Model model){
        moduleServer.refuseApply(user_id);
        logger.info("/applyExamine/refuseApply:userId="+user_id);
        List<UserApply> userApplys = moduleServer.getUserApplys();
        model.addAttribute("userApplys",userApplys);
        return "list1_1::apply_list";
    }

    /**
     * 查看信息
     * @param user_id
     * @return
     */
    @ResponseBody
    @GetMapping("/applyExamine/examineApply")
    public UserApply examineApply(@RequestParam(value = "user_id")int user_id){
        UserApply apply = moduleServer.getUserApplyMessage(user_id);
        logger.info("/applyExamine/examineApply:userId="+user_id);
        return apply;
    }

    /**
     * 初始化在籍学员
     * @param model
     * @return
     */
    @GetMapping("/absentee")
    public String absentee(Model model){
        List<UserApply> absentees = moduleServer.getUserAbsenteeAll();
        model.addAttribute("absentees",absentees);
        return "list1_2";
    }

    /**
     * 查看信息
     * @param user_id
     * @return
     */
    @ResponseBody
    @GetMapping("/absentee/examine")
    public Absentee absenteeExamine(@RequestParam(value = "user_id")int user_id){
        Absentee absentee = moduleServer.getUserAbsentee(user_id);
        return absentee;
    }
    /*
                "name":name,
            "age":age,
            "phone":phone,
            "code":code,
            "address":address,
            "sex":sex,
            "old_type_radio":old_type_radio,
            "old_type":old_type,
            "type":type,
            "file":formData,
     */

    @ResponseBody
    @RequestMapping(value = "/userApply", method = RequestMethod.POST, consumes = "multipart/form-data")
    public String webApply(@RequestParam(value = "name",required = false) String name,
//                           @RequestParam(value = "age")String age,
//                           @RequestParam(value = "phone")String phone,
//                           @RequestParam(value = "code")String code,
//                           @RequestParam(value = "address")String address,
//                           @RequestParam(value = "sex")String sex,
//                           @RequestParam(value = "old_type_radio")String old_type_radio,
//                           @RequestParam(value = "old_type")String old_type,
//                           @RequestParam(value = "type")String type,
                           @RequestParam(value = "file")MultipartFile picture){
        System.out.println(name);
//        System.out.println(age);
//        System.out.println(phone);
//        System.out.println(code);
//        System.out.println(address);
//        System.out.println(sex);
//        System.out.println(old_type_radio);
//        System.out.println(old_type);
//        System.out.println(type);
        System.out.println(picture.getName());
        System.out.println(picture.getSize());
        System.out.println(picture.getOriginalFilename());

        return "succeed";
    }
}
