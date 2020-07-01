package com.drivinggrpc.driving.server.impl;

import com.drivinggrpc.driving.dao.TopicDao;
import com.drivinggrpc.driving.po.Topic;
import com.drivinggrpc.driving.server.ExaminationServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationServerImpl implements ExaminationServer {
    @Autowired
    private TopicDao topicDao;
    @Override
    public boolean addTopic(Topic bean) {
        int result = topicDao.insertTopic(bean);
        if (result>0)
            return true;
        return false;
    }

    @Override
    public List<Topic> initExamination() {
        return topicDao.selectTopicAll();
    }

    @Override
    public void removeExamination(int id) {
        topicDao.deleteTopicById(id);
    }

    @Override
    public Topic checkExamination(int id) {
        return topicDao.selectTopicById(id);
    }
}
