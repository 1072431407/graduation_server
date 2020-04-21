package com.drivinggrpc.driving.server.impl;

import com.drivinggrpc.driving.dao.*;
import com.drivinggrpc.driving.po.Absentee;
import com.drivinggrpc.driving.po.Graduate;
import com.drivinggrpc.driving.po.News;
import com.drivinggrpc.driving.po.UserApply;
import com.drivinggrpc.driving.server.StudentAdminServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentAdminServerImpl implements StudentAdminServer {
    @Autowired
    private AbsenteeDao absenteeDao;
    @Autowired
    private NewsDao newsDao;
    @Autowired
    private UserApplyDao applyDao;
    @Autowired
    private UserStatisticsDao statisticsDao;
    @Autowired
    private GraduateDao graduateDao;

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
    public void consentApply(String user_id) {
        News news = new News();
        applyDao.updateApplyStateByUserId(user_id,"科目一");//更新用户状态
        UserApply apply = applyDao.selectApplyByUserId(user_id);
        absenteeDao.insertUserAbsentee(apply);
        news.setUser_id(user_id);
        news.setTitle("通知");
        news.setContent("您已经报名成功,请通过官网官网缴费入口或到校内进行交款.缴费入口:"+ ApplicationTools.getPhyTheFees());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        news.setDate(format.format(date));
        newsDao.insertNews(news);
        applyDao.deleteUserApplyByUserId(user_id);//删除用户报名信息
    }

    /**
     * 审批不通过
     * @param user_id
     */
    @Override
    public void refuseApply(String user_id) {
        applyDao.updateApplyStateByUserId(user_id,"未报名");//更新用户状态
        UserApply userApply = applyDao.selectApplyByUserId(user_id);
        applyDao.deleteUserApplyByUserId(user_id);//删除用户报名信息
        News news = new News();
        news.setUser_id(user_id);
        news.setTitle("通知");
        news.setContent("由于您不符合报名条件，因此报名被驳回!");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        news.setDate(format.format(date));
        newsDao.insertNews(news);
        File file = new File(userApply.getPicture());
        if (file.exists())
            file.delete();
    }

    @Override
    public List<UserApply> getUserAbsenteeAll() {
        List<UserApply> absentees = absenteeDao.selectAbsenteeAll();
        return absentees;
    }

    @Override
    public UserApply getUserApplyMessage(String user_id) {
        return applyDao.selectApplyByUserId(user_id);
    }

    @Override
    public Absentee getUserAbsentee(String user_id) {
        Absentee absentee = absenteeDao.selectAbsenteeByUserId(user_id);
        absentee.setState(applyDao.selectApplyStateByUserId(user_id));
        absentee.setDate(statisticsDao.selectUserApplyDateByUserId(user_id));
        return absentee;
    }

    @Override
    public void block(String user_id) {
        UserApply userApply = applyDao.selectApplyByUserId(user_id);
        applyDao.updateApplyStateByUserId(user_id,"未报名");//更新用户状态
        File file = new File(userApply.getPicture());
        if (file.exists())
            file.delete();
        applyDao.deleteUserApplyByUserId(user_id);//删除用户报名信息
        Graduate graduate = new Graduate();
        graduate.setUser_id(userApply.getUser_id());
        graduate.setName(userApply.getName());
        graduate.setAge(userApply.getAge());
        graduate.setCode(userApply.getCode());
        graduate.setPhone(userApply.getPhone());
        graduate.setSex(userApply.getSex());
        graduate.setType(userApply.getType());
        graduate.setState(1);//黑名单
        graduateDao.insertGraduate(graduate);
    }

    @Override
    public List<Graduate> getGraduateAll() {
        return graduateDao.selectGraduate(0);
    }

    @Override
    public void removeGraduate(String user_id) {
        graduateDao.deleteGraduateByUserId(user_id);
    }

    @Override
    public List<Graduate> getBlackListAll() {
        return graduateDao.selectGraduate(1);
    }
}
