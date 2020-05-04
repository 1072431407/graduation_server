package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.Exam;
import com.drivinggrpc.driving.po.Report;
import com.drivinggrpc.driving.server.ExamManageServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ExamManageController {

    @Autowired
    private ExamManageServer examManageServer;
    private Logger logger = ApplicationTools.logger;

    /**
     * 初始化删除考试
     * @param model
     * @return
     */
    @GetMapping("/deleteExam")
    public String initDeleteExam(Model model){
        List<Exam> listBeans = examManageServer.initDeleteExam();
        model.addAttribute("exams",listBeans);
        logger.info("/deleteExam->initDeleteExam");
        return "list2/list2_1";
    }

    /**
     * 删除考试-查看信息
     * @param exam_id
     * @return
     */
    @ResponseBody
    @GetMapping("/deleteExam/check")
    public Exam deleteExamCheck(@RequestParam(value = "exam_id")String exam_id){
        Exam exam = examManageServer.deleteExamCheck(exam_id);
        logger.info("/deleteExam/check");
        return exam;
    }

    /**
     * 删除考试-删除
     * @param exam_id
     * @param model
     * @return
     */
    @GetMapping("/deleteExam/delete")
    public String deleteExamDelete(@RequestParam(value = "exam_id")String exam_id,Model model){
        examManageServer.deleteExamDelete(exam_id);
        List<Exam> listBeans = examManageServer.initDeleteExam();
        model.addAttribute("exams",listBeans);
        logger.info("/deleteExam/delete");
        return "list2/list2_1::list";
    }

    /**
     * 初始化删除练车
     * @return
     */
    @GetMapping("/deleteExercise")
    public String initDeleteExercise(Model model){
        List<Exam> listBeans = examManageServer.initDeleteExercise();
        model.addAttribute("exams",listBeans);
        logger.info("/deleteExercise");
        return "list2/list2_4";
    }
    /**
     * 删除练车-删除
     * @param exam_id
     * @param model
     * @return
     */
    @GetMapping("/deleteExercise/delete")
    public String deleteExerciseDelete(@RequestParam(value = "exam_id")String exam_id,Model model){
        examManageServer.deleteExamDelete(exam_id);
        List<Exam> listBeans = examManageServer.initDeleteExam();
        model.addAttribute("exams",listBeans);
        logger.info("/deleteExercise/delete");
        return "list2/list2_4::list";
    }
    /**
     * 删除练车-查看信息
     * @param exam_id
     * @return
     */
    @ResponseBody
    @GetMapping("/deleteExercise/check")
    public Exam deleteExerciseCheck(@RequestParam(value = "exam_id")String exam_id){
        Exam exam = examManageServer.deleteExamCheck(exam_id);
        logger.info("/deleteExercise/check");
        return exam;
    }
    /**
     * 添加考试-添加
     * @param exam_type
     * @param year
     * @param month
     * @param day
     * @param max
     * @param address
     * @param remark
     * @return
     */
    @ResponseBody
    @GetMapping("/addExam/add")
    public String addExam(@RequestParam(value = "exam_type")String exam_type,
                        @RequestParam(value = "year")String year,
                        @RequestParam(value = "month")String month,
                        @RequestParam(value = "day")String day,
                        @RequestParam(value = "max")int max,
                        @RequestParam(value = "address")String address,
                        @RequestParam(value = "remark",required = false)String remark,
                        @RequestParam(value = "time")String time,
                          @RequestParam(value = "typeCode")String typeCode){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date=sdf.parse(year+"-"+month+"-"+day);
        } catch (ParseException ex) {}

        long dateTime = date.getTime();
        if (dateTime < System.currentTimeMillis()+4*24*60*60*1000*12)//比当前日期大5天
            return "选择的日期必须比当前日期大五天";
        Exam exam = new Exam();
        exam.setType(exam_type);
        exam.setData(year+"-"+month+"-"+day);
        exam.setMax(max);
        exam.setAddress(address);
        exam.setTime(time);
        exam.setType_code(typeCode);
        if (remark!=null)
            exam.setRemark(remark);
        logger.info("/addExam/add");
        if(examManageServer.addExam(exam))
            return "succeed";
        else
            return "添加失败";
    }

    /**
     * 添加练车-添加
     * @param exam_type
     * @param startYear
     * @param startMonth
     * @param startDay
     * @param overYear
     * @param overMonth
     * @param overDay
     * @param max
     * @param address
     * @param duration
     * @param remark
     * @param time
     * @return
     */
    @ResponseBody
    @GetMapping("/addExercise/add")
    public String addExercise(@RequestParam(value = "exam_type")String exam_type,
                              @RequestParam(value = "startYear")String startYear,
                              @RequestParam(value = "startMonth")String startMonth,
                              @RequestParam(value = "startDay")String startDay,
                              @RequestParam(value = "overYear")String overYear,
                              @RequestParam(value = "overMonth")String overMonth,
                              @RequestParam(value = "overDay")String overDay,
                              @RequestParam(value = "max")int max,
                              @RequestParam(value = "address")String address,
                              @RequestParam(value = "duration")int duration,
                              @RequestParam(value = "remark",required = false)String remark,
                              @RequestParam(value = "time")String time,
                              @RequestParam(value = "typeCode")String typeCode){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Exam> listBeans = new ArrayList<>();
        try {
            Date startDate=sdf.parse(startYear+"-"+startMonth+"-"+startDay);
            Date overDate=sdf.parse(overYear+"-"+overMonth+"-"+overDay);
            while (true){
                if (startDate.getTime() > overDate.getTime())
                    break;
                else {
                    Exam bean = new Exam();
                    bean.setType(exam_type);
                    bean.setData(sdf.format(startDate));
                    bean.setMax(max);
                    bean.setAddress(address);
                    bean.setTime(time);
                    bean.setType_code(typeCode);
                    if (remark!=null)
                        bean.setRemark(remark);
                    bean.setDuration(duration);
                    listBeans.add(bean);
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(startDate);
                    calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
                    startDate = calendar.getTime();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logger.info("/addExercise/add");
        if (examManageServer.addExercise(listBeans))
            return "succeed";
        else
            return "添加失败";
    }


    /**
     * 初始化成绩录入
     * @param model
     * @return
     */
    @GetMapping("/loggingData")
    public String initLoggingData(Model model){
        List<Report> listBeans = examManageServer.initLoggingData();
        model.addAttribute("reports",listBeans);
        logger.info("/loggingData");
        return "list2/list2_2";
    }

    /**
     * 成绩录入-合格
     * @param user_id
     * @param model
     * @return
     */
    @GetMapping("/loggingData/eligible")
    public String eligible(@RequestParam(value = "user_id")String user_id,Model model){
        List<Report> listBeans = examManageServer.eligible(user_id);
        model.addAttribute("reports",listBeans);
        logger.info("/loggingData/eligible");
        return "list2/list2_2::list";
    }

    /**
     * 成绩录入-不合格
     * @param user_id
     * @param model
     * @return
     */
    @GetMapping("/loggingData/uneligible")
    public String unEligible(@RequestParam(value = "user_id")String user_id,Model model){
        List<Report> listBeans = examManageServer.unEligible(user_id);
        model.addAttribute("reports",listBeans);
        logger.info("/loggingData/uneligible");
        return "list2/list2_2::list";
    }

    /**
     * 成绩录入-查看考试信息
     * @param exam_id
     * @return
     */
    @ResponseBody
    @GetMapping("/loggingData/check")
    public Exam loggingDataCheck(@RequestParam(value = "exam_id")String exam_id){
        Exam exam = examManageServer.deleteExamCheck(exam_id);
        logger.info("/loggingData/check");
        return exam;
    }
}
