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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        List<Exam> listBeans = new ArrayList<>();
        List<Exam> list = examTableDao.selectExamByState(0);
        long presentTime = new Date().getTime();
        if (list.size()>0){
            for (Exam exam:list){
                try {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    long time = format.parse(exam.getData()).getTime();
                    if (presentTime<time)
                        listBeans.add(exam);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return listBeans;
    }

    @Override
    public Exam deleteExamCheck(String exam_id) {
        return examTableDao.selectExamByExamId(exam_id);
    }

    @Override
    public void deleteExamDelete(String exam_id) {
        reportDao.deleteReportByExamId(exam_id);
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
        List<Exam> listBeans = new ArrayList<>();
        long presentTime = new Date().getTime();
        if (list.size()>0){
            for (Exam exam:list){
                try {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    long time = format.parse(exam.getData()).getTime();
                    if (presentTime<time)
                        listBeans.add(exam);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return listBeans;
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
        if ("科目二".equals(state)){
            userApplyDao.updateApplyStateByUserId(user_id,"科目三");
        }
        if ("科目三".equals(state)){
            userApplyDao.updateApplyStateByUserId(user_id,"科目四");
        }
        if ("科目四".equals(state)){
            userApplyDao.updateApplyStateByUserId(user_id,"毕业");
            News news = new News();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            news.setDate(format.format(new Date()));
            news.setTitle("通知");
            news.setContent("恭喜您已完成所有考试!请三个工作日后前往xx街道xx室领取驾驶证件.");
            news.setUser_id(user_id);
            newsDao.insertNews(news);
        }
        userApplyDao.updateIsFirstByUserId(0,user_id);
        userApplyDao.updateIsPayByUserId(0,user_id);
        reportDao.deleteReportByUserId(user_id);
        List<Report> list = reportDao.selectAllByState(0);
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
        userApplyDao.updateIsFirstByUserId(1,user_id);//修改为不是第一次考试
        userApplyDao.updateIsPayByUserId(0,user_id);//缴费状态为未缴费
        reportDao.deleteReportByUserId(user_id);
        List<Report> list = reportDao.selectAllByState(0);
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
        List<Report> list = reportDao.selectAllByState(0);
        long presentTime = new Date().getTime()+2*60*60*1000;
        List<Report> listBeans = new ArrayList<>();
        for (Report item:list){
            try {
                Exam exam = examTableDao.selectExamByExamId(item.getExam_id());
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                long time = format.parse(exam.getData()).getTime();
                if (time>presentTime)
                    continue;
                item.setType(exam.getType());
                item.setData(exam.getData());
                item.setTime(exam.getTime());
                item.setAddress(exam.getAddress());
                Absentee absentee = absenteeDao.selectAbsenteeByUserId(item.getUser_id());
                item.setName(absentee.getName());
                listBeans.add(item);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return listBeans;
    }

}
