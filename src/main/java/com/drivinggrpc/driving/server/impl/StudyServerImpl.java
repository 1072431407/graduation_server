package com.drivinggrpc.driving.server.impl;

import com.drivinggrpc.driving.dao.TopicDao;
import com.drivinggrpc.driving.dao.UserStatisticsDao;
import com.drivinggrpc.driving.po.Topic;
import com.drivinggrpc.driving.po.UserStatistics;
import com.drivinggrpc.driving.server.StudyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudyServerImpl implements StudyServer {
    @Autowired
    private TopicDao topicDao;
    @Autowired
    private UserStatisticsDao userStatisticsDao;
    @Override
    public List<Topic> getExam(String type) {
        List<Topic> list = topicDao.selectTopicByType(type);
        Set<Topic> set = new HashSet<>(list);
        if (set.size()>100){
            Set<Topic> set1 = new HashSet<>();
            Iterator<Topic> iterator = set.iterator();
            int index = 0;
            while (iterator.hasNext()){
                if (index >= 100)
                    break;
                set1.add(iterator.next());
                index++;
            }
            return new ArrayList<>(set1);
        }else
            return list;
    }

    @Override
    public List<Topic> getTopic(String type, String state) {//随机练习、顺序练习、背题模式
        List<Topic> list = topicDao.selectTopicByType(type);
        if ("随机练习".equals(state))
            return new ArrayList<>(new HashSet<>(list));
        return list;
    }

    /**
     * 答题统计
     * @param userId
     * @param type
     * @param num
     * @param sum
     */
    @Override
    public void answerOfStatistical(String userId, String type, int num, int sum) {
        UserStatistics userStatistics = userStatisticsDao.selectUserStatisticsAllByUserId(userId);
        if ("科目一".equals(type)){
            int isok = (int)(userStatistics.getNum_questions_1()*userStatistics.getAccuracy_1()/100.0);
            isok += num;
            userStatistics.setNum_questions_1(userStatistics.getNum_questions_1()+sum);
            userStatistics.setAccuracy_1((int)((double)isok/userStatistics.getNum_questions_1()*100));
            userStatisticsDao.updateNum1(userStatistics.getNum_questions_1(),userId);
            userStatisticsDao.updateAcc1(userStatistics.getAccuracy_1(),userId);
        }
        if ("科目四".equals(type)){
            int isok = (int)(userStatistics.getNum_questions_4()*userStatistics.getAccuracy_4()/100.0);
            isok += num;
            userStatistics.setNum_questions_4(userStatistics.getNum_questions_4()+sum);
            userStatistics.setAccuracy_4((int)((double)isok/userStatistics.getNum_questions_4()*100));
            userStatisticsDao.updateNum4(userStatistics.getNum_questions_4(),userId);
            userStatisticsDao.updateAcc4(userStatistics.getAccuracy_4(),userId);
        }
    }

    /**
     * 模拟考试统计
     * @param userId
     * @param type
     * @param num
     */
    @Override
    public void testStatistics(String userId, String type, int num) {
        UserStatistics userStatistics = userStatisticsDao.selectUserStatisticsAllByUserId(userId);
        if ("科目一".equals(type)) {
            int sum = userStatistics.getAver_score_1()+num;
            userStatistics.setAver_score_1(sum/(userStatistics.getDegree_1()+1));
            userStatistics.setDegree_1(userStatistics.getDegree_1()+1);
            userStatisticsDao.updateAve1(userStatistics.getAver_score_1(),userId);
            userStatisticsDao.updateDeg1(userStatistics.getDegree_1(),userId);
        }
        if ("科目四".equals(type)) {
            int sum = userStatistics.getAver_score_4()+num;
            userStatistics.setAver_score_4(sum/(userStatistics.getDegree_4()+1));
            userStatistics.setDegree_4(userStatistics.getDegree_4()+1);
            userStatisticsDao.updateAve4(userStatistics.getAver_score_4(),userId);
            userStatisticsDao.updateDeg4(userStatistics.getDegree_4(),userId);
        }
    }
}
