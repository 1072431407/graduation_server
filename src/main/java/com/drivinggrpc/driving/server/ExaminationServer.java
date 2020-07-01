package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.Topic;

import java.util.List;

public interface ExaminationServer {
    boolean addTopic(Topic bean);

    List<Topic> initExamination();

    void removeExamination(int id);

    Topic checkExamination(int id);
}
