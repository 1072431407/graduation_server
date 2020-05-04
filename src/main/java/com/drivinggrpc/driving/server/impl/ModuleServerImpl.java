package com.drivinggrpc.driving.server.impl;

import com.drivinggrpc.driving.dao.*;
import com.drivinggrpc.driving.po.*;
import com.drivinggrpc.driving.server.ModuleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ModuleServerImpl implements ModuleServer {
    @Autowired
    private UserApplyDao applyDao;
    @Autowired
    private UserStatisticsDao statisticsDao;
    @Autowired
    private GraduateDao graduateDao;
    @Autowired
    private ExamTableDao examTableDao;
    @Autowired
    private ReportDao reportDao;
    @Autowired
    private AbsenteeDao absenteeDao;
    @Autowired
    private NewsDao newsDao;
    @Autowired
    private BillDao billDao;
    @Override
    public String userApply(UserApply userApply,String date) {
        int userApplyKey = applyDao.insertUserApply(userApply);
        if (userApplyKey==1){
            UserStatistics statistics = new UserStatistics();
            statistics.setUser_id(userApply.getUser_id());
            statistics.setDate(date);
            Graduate graduate = graduateDao.selectGraduateByUserId(userApply.getUser_id());
            if (graduate != null){
                applyDao.deleteUserApplyByUserId(userApply.getUser_id());
                return "报名失败";
            }

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
    public String getApplyStateByUserId(String userId) {
        String state = applyDao.selectApplyStateByUserId(userId);
        return state;
    }

    @Override
    public UserStatistics getStatisticsData(String userId) {
        UserStatistics statistics = statisticsDao.selectUserStatisticsAllByUserId(userId);
        return statistics;
    }

    @Override
    public List<Exam> getExam(int state) {
        List<Exam> list = new ArrayList<>();
        switch (state){
            case 1:
                list = examTableDao.selectExamByType("科目一",0);
                break;
            case 2:
                list = examTableDao.selectExamByType("科目二",0);
                break;
            case 3:
                list = examTableDao.selectExamByType("科目三",0);
                break;
            case 4:
                list = examTableDao.selectExamByType("科目四",0);
                break;
        }
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

    @Override
    public String applyExam(String examId, String userId) {
        String type = absenteeDao.selectTypeByUserId(userId);
        String examType = examTableDao.selectTypeByExamId(examId);
        if (type == null || examType == null || "".equals(type) || "".equals(examType) || !type.equals(examType))
            return "您不能报名该练习项目,请选择"+type+"类型的练习项目!";
        Report old = reportDao.selectReport(userId,examId);
        if (old == null){
            Report report = new Report();
            report.setUser_id(userId);
            report.setExam_id(examId);
            report.setApplyTime(new Date().getTime());
            report.setState(0);
            int key = reportDao.insertReport(report);
            if (key>0){
                int max = examTableDao.selectExamMaxByExamId(examId);
                int num = examTableDao.selectExamNumByExamId(examId);
                if (num<max){
                    examTableDao.updateExamNumByExamId(examId,num+1);
                    int isFirst = applyDao.selectIsFirstByUserId(userId);
                    if (isFirst == 1){
                        News news = new News();
                        news.setUser_id(userId);
                        news.setContent("由于您不是第一次参加该项考核,所以您需要缴纳xx元的费用.请于考试日期前1日内完成缴费!");
                        news.setTitle("通知");
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        news.setDate(format.format(new Date()));
                        newsDao.insertNews(news);

                        Bill bill = new Bill();
                        bill.setCause("考试费用");
                        bill.setDate(new Date().getTime());
                        bill.setMoney(200);
                        bill.setUser_id(userId);
                        billDao.insertBill(bill);
                    }else {
                        applyDao.updateIsFirstByUserId(1,userId);
                    }
                    return "succeed";
                }else
                    return "报名人数已满!";

            }else
                return "报名失败!";
        }
        return "您已经参加了考试,不能报名!";
    }

    @Override
    public List<Exam> getExercise(int state) {
        List<Exam> list = new ArrayList<>();
        switch (state){
            case 2:
                list = examTableDao.selectExamByType("科目二",1);
                break;
            case 3:
                list = examTableDao.selectExamByType("科目三",1);
                break;
        }
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
     * 预约练车 -预约
     * @param examId
     * @param userId
     * @return
     */
    @Override
    public String applyExercise(String examId, String userId) {
        String type = absenteeDao.selectTypeByUserId(userId);
        String examType = examTableDao.selectTypeByExamId(examId);
        if (type == null || examType == null || "".equals(type) || "".equals(examType) || !type.equals(examType))
            return "您不能报名该考试,请选择"+type+"类型的考试!";
        Report old = reportDao.selectReport(userId,examId);
        if (old == null){
            Report report = new Report();
            report.setUser_id(userId);
            report.setExam_id(examId);
            report.setApplyTime(new Date().getTime());
            report.setState(1);
            int key = reportDao.insertReport(report);
            if (key>0){
                int max = examTableDao.selectExamMaxByExamId(examId);
                int num = examTableDao.selectExamNumByExamId(examId);
                if (num<max){
                    examTableDao.updateExamNumByExamId(examId,num+1);
                    return "succeed";
                }else
                    return "报名人数已满!";

            }else
                return "报名失败!";
        }
        return "您已经参加了考试,不能报名!";
    }

    @Override
    public List<News> getNews(String userId) {
        List<News> list = newsDao.selectNewsByUserId(userId);
        return list;
    }

    @Override
    public List<Bill> getBill(String userId) {
        List<Bill> list = billDao.selectBillByUserId(userId);
        return list;
    }

    @Override
    public void readNews(int id) {
        newsDao.updateStateById(id,1);
    }

    @Override
    public String billPay(int id) {
        if (billDao.updateStateById(id,1)>0)
            return "succeed";
        return "fail";
    }
}
