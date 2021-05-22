//package com.drivinggrpc.driving.controller;
//
//import com.drivinggrpc.driving.po.*;
//import com.drivinggrpc.driving.rpc.proto.module.*;
//import com.drivinggrpc.driving.server.ModuleServer;
//import com.drivinggrpc.driving.tools.ApplicationTools;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Controller
//public class ModuleController {
//    private Logger logger = ApplicationTools.logger;
//    @Autowired
//    private ModuleServer moduleServer;
//
//    /**
//     * 用户报名
//     * @param request
//     * @param picture
//     * @return
//     */
//    public ApplyResponse userApply(ApplyRequest request,String picture){
//        UserApply apply = new UserApply();
//        apply.setUser_id(request.getUserId());
//        apply.setPicture(picture);
//        apply.setName(request.getName());
//        apply.setSex(request.getSex());
//        apply.setAge(request.getAge());
//        apply.setAddress(request.getAddress());
//        apply.setPhone(request.getPhone());
//        apply.setOld_type(request.getOldType());
//        apply.setType(request.getType());
//        apply.setCode(request.getCode());
//        String state = moduleServer.userApply(apply,request.getDate());
//        ApplyResponse response = ApplyResponse.newBuilder()
//                .setState(state)
//                .build();
//        logger.info("userApply:userId="+request.getUserId()+"-->state="+state);
//        return response;
//    }
//
//    /**
//     * 返回用户当前进度
//     * @param userId
//     * @return
//     */
//    public ApplyStateResponse getApplyState(String userId) {
//        ApplyStateResponse response = ApplyStateResponse.newBuilder().setState(moduleServer.getApplyStateByUserId(userId)).build();
//        logger.info("getApplyState:userId="+userId+"-->state="+response.getState());
//        return response;
//    }
//
//    /**
//     * 返回用户科目一、四统计数据
//     * @param request
//     * @return
//     */
//    public StatisticsDataResponse getStatisticsData(StatisticsDataRequest request) {
//        UserStatistics statistics = moduleServer.getStatisticsData(request.getUserId());
//        StatisticsDataResponse response = null;
//        if (request.getRequestType() == StatisticsDataRequest.REQUEST_TYPE.SUBJECT_1){
//            response = StatisticsDataResponse.newBuilder()
//                    .setNumQuestions(statistics.getNum_questions_1()+"")
//                    .setAccuracy("正确率:"+statistics.getAccuracy_1()+"%")//正确率:50%
//                    .setAverScore(statistics.getAver_score_1()+"")
//                    .setDegree("累计考试次数:"+statistics.getDegree_1()+"次")//累计考试次数:5次
//                    .build();
//        }
//        if (request.getRequestType() == StatisticsDataRequest.REQUEST_TYPE.SUBJECT_4){
//            response = StatisticsDataResponse.newBuilder()
//                    .setNumQuestions(statistics.getNum_questions_4()+"")
//                    .setAccuracy("正确率:"+statistics.getAccuracy_4()+"%")//正确率:50%
//                    .setAverScore(statistics.getAver_score_4()+"")
//                    .setDegree("累计考试次数:"+statistics.getDegree_4()+"次")//累计考试次数:5次
//                    .build();
//        }
//        logger.info("StatisticsDataResponse:userId="+request.getUserId()+",REQUEST_TYPE="+request.getRequestType());
//        return response;
//    }
//
//    /**
//     * 获取考试 练车列表
//     * @param state
//     * @return
//     */
//    public List<ExamResponse> getExam(int state) {
//        List<Exam> list = moduleServer.getExam(state);
//        List<ExamResponse> listBeans = new ArrayList<>();
//        if (list != null){
//            for (Exam exam:list){
//                ExamResponse response = ExamResponse.newBuilder()
//                        .setExamId(exam.getExam_id())
//                        .setType(exam.getType())
//                        .setData(exam.getData())
//                        .setTime(exam.getTime())
//                        .setMax(exam.getMax())
//                        .setNum(exam.getNum())
//                        .setAddress(exam.getAddress())
//                        .setRemark(exam.getRemark())
//                        .setDuration(exam.getDuration())
//                        .setTypeCode(exam.getType_code())
//                        .build();
//                listBeans.add(response);
//            }
//        }
//        return listBeans;
//    }
//
//    /**
//     * 报名考试 报名
//     * @param examId
//     * @param userId
//     * @return 成功succeed  失败返回失败信息
//     */
//    public ApplyExamResponse applyExam(String examId, String userId) {
//        String state = moduleServer.applyExam(examId,userId);
//        ApplyExamResponse response = ApplyExamResponse.newBuilder()
//                .setState(state)
//                .build();
//        return response;
//    }
//
//    public List<ExamResponse> getExercise(int state) {
//        List<Exam> list = moduleServer.getExercise(state);
//        List<ExamResponse> listBeans = new ArrayList<>();
//        if (list != null){
//            for (Exam exam:list){
//                ExamResponse response = ExamResponse.newBuilder()
//                        .setExamId(exam.getExam_id())
//                        .setType(exam.getType())
//                        .setData(exam.getData())
//                        .setTime(exam.getTime())
//                        .setMax(exam.getMax())
//                        .setNum(exam.getNum())
//                        .setAddress(exam.getAddress())
//                        .setRemark(exam.getRemark())
//                        .setDuration(exam.getDuration())
//                        .setTypeCode(exam.getType_code())
//                        .build();
//                listBeans.add(response);
//            }
//        }
//        return listBeans;
//    }
//
//    public ApplyExamResponse applyExercise(String examId, String userId) {
//        String state = moduleServer.applyExercise(examId,userId);
//        ApplyExamResponse response = ApplyExamResponse.newBuilder()
//                .setState(state)
//                .build();
//        return response;
//    }
//
//    public List<NewsResponse> getNews(String userId) {
//        List<NewsResponse> list = new ArrayList<>();
//        List<News> listBeans = moduleServer.getNews(userId);
//        if (listBeans != null){
//            for(News item:listBeans){
//                NewsResponse response = NewsResponse.newBuilder()
//                        .setContent(item.getContent())
//                        .setUserId(item.getUser_id())
//                        .setTitle(item.getTitle())
//                        .setDate(item.getDate())
//                        .setState(item.getState())
//                        .setId(item.getId())
//                        .build();
//                list.add(response);
//            }
//        }
//        return list;
//    }
//
//    public List<BillResponse> getBill(String userId) {
//        List<BillResponse> list = new ArrayList<>();
//        List<Bill> listBeans = moduleServer.getBill(userId);
//        if (listBeans != null){
//            for(Bill item:listBeans){
//                BillResponse response = BillResponse.newBuilder()
//                        .setUserId(item.getUser_id())
//                        .setDate(item.getDate())
//                        .setCause(item.getCause())
//                        .setMoney(item.getMoney())
//                        .setState(item.getState())
//                        .setId(item.getId())
//                        .build();
//                list.add(response);
//            }
//        }
//        return list;
//    }
//
//    public void readNews(int id) {
//        moduleServer.readNews(id);
//    }
//
//    public PayResponse billPay(int id) {
//        String state = moduleServer.billPay(id);
//        return PayResponse.newBuilder().setState(state).build();
//    }
//}
