package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.Topic;

import java.util.List;

public interface StudyServer {
    List<Topic> getExam(String type);

    List<Topic> getTopic(String type, String state);

    void answerOfStatistical(String userId, String type, int num, int sum);

    void testStatistics(String userId, String type, int num);
}
