//package com.drivinggrpc.driving.controller;
//
//import com.drivinggrpc.driving.po.Topic;
//import com.drivinggrpc.driving.rpc.proto.study.GetTopicResponse;
//import com.drivinggrpc.driving.server.StudyServer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class StudyController {
//    @Autowired
//    private StudyServer studyServer;
//
//    public List<GetTopicResponse> getExam(String type) {
//        List<Topic> list = studyServer.getExam(type);
//        List<GetTopicResponse> listBeans = new ArrayList<>();
//        if (list!=null)
//            for (Topic topic:list){
//                GetTopicResponse response = GetTopicResponse.newBuilder()
//                        .setTopic(topic.getTopic())
//                        .setRadioA(topic.getRadio_a())
//                        .setRadioB(topic.getRadio_b())
//                        .setRadioC(topic.getRadio_c())
//                        .setRadioD(topic.getRadio_d())
//                        .setCorrectRadio(topic.getCorrect_radio())
//                        .setSwitchRadio(0)
//                        .setTips(topic.getTips())
//                        .build();
//                listBeans.add(response);
//            }
//        return listBeans;
//    }
//
//    public List<GetTopicResponse> getTopic(String type, String state) {
//        List<Topic> list = studyServer.getTopic(type,state);
//        List<GetTopicResponse> listBeans = new ArrayList<>();
//        if (list!=null)
//            for (Topic topic:list){
//                GetTopicResponse response = GetTopicResponse.newBuilder()
//                        .setTopic(topic.getTopic())
//                        .setRadioA(topic.getRadio_a())
//                        .setRadioB(topic.getRadio_b())
//                        .setRadioC(topic.getRadio_c())
//                        .setRadioD(topic.getRadio_d())
//                        .setCorrectRadio(topic.getCorrect_radio())
//                        .setSwitchRadio(0)
//                        .setTips(topic.getTips())
//                        .build();
//                listBeans.add(response);
//            }
//        return listBeans;
//    }
//
//    public void submitStatistics(int num, int sum, String type, int label, String userId,long time) {
//        if (label == 1)
//            QueAcc(userId,type,num,sum,time);
//        if (label == 2)
//            AveDeg(userId,type,num,time);
//    }
//
//    /**
//     * 答题统计
//     * @param userId
//     * @param type
//     * @param num
//     * @param sum
//     */
//    private void QueAcc(String userId, String type, int num, int sum,long time) {
//        studyServer.upMinute(time,userId);
//        studyServer.answerOfStatistical(userId,type,num,sum);
//    }
//
//    /**
//     * 模拟考试统计
//     * @param userId
//     * @param type
//     * @param num
//     */
//    private void AveDeg(String userId, String type, int num,long time) {
//        studyServer.upMinute(time,userId);
//        studyServer.testStatistics(userId,type,num);
//    }
//}
