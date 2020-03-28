package com.drivinggrpc.driving.server.impl;

import com.drivinggrpc.driving.dao.AbsenteeDao;
import com.drivinggrpc.driving.dao.NewsDao;
import com.drivinggrpc.driving.dao.UserApplyDao;
import com.drivinggrpc.driving.dao.UserStatisticsDao;
import com.drivinggrpc.driving.po.News;
import com.drivinggrpc.driving.po.UserApply;
import com.drivinggrpc.driving.po.UserStatistics;
import com.drivinggrpc.driving.server.ModuleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ModuleServerImpl implements ModuleServer {
    @Autowired
    private UserApplyDao applyDao;
    @Autowired
    private UserStatisticsDao statisticsDao;

    @Autowired
    private AbsenteeDao absenteeDao;
    @Autowired
    private NewsDao newsDao;
    @Override
    public String userApply(UserApply userApply,String date) {
        int userApplyKey = applyDao.insertUserApply(userApply);
        if (userApplyKey==1){
            UserStatistics statistics = new UserStatistics();
            statistics.setUser_id(userApply.getUser_id());
            statistics.setDate(date);
            int userStatisticsKey = statisticsDao.updateToDateByUserId(statistics);
            if (userStatisticsKey == 1){
                applyDao.updateApplyStateByUserId(userApply.getUser_id(),"审批中");
                return "报名成功";
            }else{
                applyDao.deleteUserApplyByUserId(userApply.getUser_id());
                return "报名失败";
            }
        }else{
            return "报名失败";
        }
    }

    @Override
    public String getApplyStateByUserId(int userId) {
        String state = applyDao.selectApplyStateByUserId(userId);
        return state;
    }

    @Override
    public UserStatistics getStatisticsData(int userId) {
        UserStatistics statistics = statisticsDao.selectUserStatisticsAllByUserId(userId);
        return statistics;
    }

    @Override
    public List<UserApply> getUserApplys() {
        List<UserApply> userApplies = applyDao.selectApplyAll();
        return userApplies;
    }

    /**
     * 审批通过
     * @param user_id
     */
    @Override
    public void consentApply(int user_id) {
        applyDao.updateApplyStateByUserId(user_id,"科目一");//更新用户状态
        UserApply apply = applyDao.selectApplyByUserId(user_id);
        absenteeDao.insertUserAbsentee(apply);
        applyDao.deleteUserApplyByUserId(user_id);//删除用户报名信息
    }

    /**
     * 审批不通过
     * @param user_id
     */
    @Override
    public void refuseApply(int user_id) {
        applyDao.updateApplyStateByUserId(user_id,"未报名");//更新用户状态
        applyDao.deleteUserApplyByUserId(user_id);//删除用户报名信息
        News news = new News();
        news.setUser_id(user_id);
        news.setTitle("通知");
        news.setContent("由于您不符合报名条件，因此报名被驳回!");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        news.setDate(format.format(date));
        newsDao.insertNews(news);
    }

    @Override
    public List<UserApply> getUserAbsentee() {
        List<UserApply> absentees = absenteeDao.selectAbsenteeAll();
        return absentees;
    }
}
