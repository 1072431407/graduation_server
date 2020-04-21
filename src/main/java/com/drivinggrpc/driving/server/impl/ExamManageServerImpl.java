package com.drivinggrpc.driving.server.impl;

import com.drivinggrpc.driving.dao.*;
import com.drivinggrpc.driving.po.Absentee;
import com.drivinggrpc.driving.po.Exam;
import com.drivinggrpc.driving.po.News;
import com.drivinggrpc.driving.po.Report;
import com.drivinggrpc.driving.server.ExamManageServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExamManageServerImpl implements ExamManageServer {
    @Autowired
    private ExamTableDao examTableDao;
    @Autowired
    private UserApplyDao userApplyDao;
    @Autowired
    private ReportDao reportDao;
    @Autowired
    private AbsenteeDao absenteeDao;

    @Autowired
    private NewsDao newsDao;
    @Override
    public List<Exam> initDeleteExam() {
        List<Exam> list = examTableDao.selectExamByState(0);
        return list;
    }

    @Override
    public Exam deleteExamCheck(String exam_id) {
        return examTableDao.selectExamByExamId(exam_id);
    }

    @Override
    public void deleteExamDelete(String exam_id) {
        examTableDao.deleteExamByExamId(exam_id);
    }

    @Override
    public boolean addExam(Exam exam) {
        exam.setExam_id(ApplicationTools.getUUID());
        exam.setState(0);
        int key = examTableDao.insertExam(exam);
        if (key>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean addExercise(List<Exam> listBeans) {
        if (listBeans == null || listBeans.size() == 0)
            return false;
        for (Exam item:listBeans){
            item.setExam_id(ApplicationTools.getUUID());
            item.setState(1);
            int key = examTableDao.insertExam(item);
            if (key == 0)
                return false;
        }
        return true;
    }

    @Override
    public List<Exam> initDeleteExercise() {
        List<Exam> list = examTableDao.selectExamByState(1);
        return list;
    }

    /**
     * 合格
     * @param user_id
     * @return
     */
    @Override
    public List<Report> eligible(String user_id) {
        String state = userApplyDao.selectApplyStateByUserId(user_id);
        if ("科目一".equals(state)){
            userApplyDao.updateApplyStateByUserId(user_id,"科目二");
        }
        reportDao.deleteReportByUserId(user_id);
        List<Report> list = reportDao.selectAll();
        for (Report item:list){
            Exam exam = examTableDao.selectExamByExamId(item.getExam_id());
            item.setType(exam.getType());
            item.setData(exam.getData());
            item.setTime(exam.getTime());
            item.setAddress(exam.getAddress());
            Absentee absentee = absenteeDao.selectAbsenteeByUserId(item.getUser_id());
            item.setName(absentee.getName());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        News news = new News();
        news.setDate(sdf.format(new Date()));
        news.setTitle("通知");
        news.setContent("恭喜您通过"+state);
        news.setUser_id(user_id);
        newsDao.insertNews(news);
        return list;
    }

    /**
     * 不合格
     * @param user_id
     * @return
     */
    @Override
    public List<Report> unEligible(String user_id) {
        News news = new News();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        news.setDate(sdf.format(new Date()));
        news.setTitle("通知");
        news.setContent("您没有通过考试,请认真学习后再次参加!");
        news.setUser_id(user_id);
        newsDao.insertNews(news);
        reportDao.deleteReportByUserId(user_id);
        List<Report> list = reportDao.selectAll();
        for (Report item:list){
            Exam exam = examTableDao.selectExamByExamId(item.getExam_id());
            item.setType(exam.getType());
            item.setData(exam.getData());
            item.setTime(exam.getTime());
            item.setAddress(exam.getAddress());
            Absentee absentee = absenteeDao.selectAbsenteeByUserId(item.getUser_id());
            item.setName(absentee.getName());
        }
        return list;
    }

    @Override
    public List<Report> initLoggingData() {
        List<Report> list = reportDao.selectAll();
        for (Report item:list){
            Exam exam = examTableDao.selectExamByExamId(item.getExam_id());
            item.setType(exam.getType());
            item.setData(exam.getData());
            item.setTime(exam.getTime());
            item.setAddress(exam.getAddress());
            Absentee absentee = absenteeDao.selectAbsenteeByUserId(item.getUser_id());
            item.setName(absentee.getName());
        }
        return list;
    }

}
