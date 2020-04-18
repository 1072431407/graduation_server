package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.Exam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ExamManageController {


    @GetMapping("/deleteExam")
    public String initDeleteExam(Model model){
        List<Exam> listBeans = new ArrayList<>();
        Exam exam = new Exam();
        exam.setAddress("吉林省吉林市龙潭区xx街xx号xx楼");
        exam.setMax(50);
        exam.setData("2019-15-6");
        exam.setType("科目一");
        exam.setRemark("吉林省吉林市龙潭区xx街xx号xx楼吉林省吉林市龙潭区xx街xx号xx楼吉林省吉林市龙潭区xx街xx号xx楼");
        exam.setExam_id("11111");
        listBeans.add(exam);
        model.addAttribute("exams",listBeans);
        return "list2/list2_1";
    }
    @ResponseBody
    @GetMapping("/deleteExam/check")
    public Exam deleteExamCheck(@RequestParam(value = "exam_id")String exam_id){
        System.out.println(exam_id);
        Exam exam = new Exam();
        exam.setAddress("吉林省吉林市龙潭区xx街xx号xx楼");
        exam.setMax(50);
        exam.setData("2019-15-6");
        exam.setType("科目一");
        exam.setRemark("吉林省吉林市龙潭区xx街xx号xx楼吉林省吉林市龙潭区xx街xx号xx楼吉林省吉林市龙潭区xx街xx号xx楼");
        exam.setExam_id("11111");
        return exam;
    }

    @GetMapping("/deleteExam/delete")
    public String deleteExam(@RequestParam(value = "exam_id")String exam_id,Model model){
        System.out.println(exam_id);
        List<Exam> listBeans = new ArrayList<>();
        Exam exam = new Exam();
        exam.setExam_id("11111");
        exam.setAddress("吉林省吉林市龙潭区xx街xx号xx楼");
        exam.setMax(50);
        exam.setData("2019-15-6");
        exam.setType("科目一");
        exam.setRemark("444444444444444444444444444444444444444444444444444444444444444444444");
        listBeans.add(exam);
        listBeans.add(exam);
        listBeans.add(exam);
        model.addAttribute("exams",listBeans);
        return "list2/list2_1::list";
    }

    @GetMapping("/deleteExercise")
    public String deleteExercise(){
        return "list2/list2_4";
    }
    @ResponseBody
    @GetMapping("/addExam/add")
    public String addExam(@RequestParam(value = "exam_type")String exam_type,
                        @RequestParam(value = "year")String year,
                        @RequestParam(value = "month")String month,
                        @RequestParam(value = "day")String day,
                        @RequestParam(value = "max")String max,
                        @RequestParam(value = "address")String address,
                        @RequestParam(value = "remark",required = false)String remark){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date=sdf.parse(year+"-"+month+"-"+day);
        } catch (ParseException ex) {}

        long time = date.getTime();
        if (time < System.currentTimeMillis()+4*24*60*60*1000*12)//比当前日期大5天
            return "选择的日期必须比当前日期大五天";
        if (remark == null)
            remark = "";

        System.out.println(exam_type);
        System.out.println(year+"-"+month+"-"+day);
        System.out.println(max);
        System.out.println(address);
        System.out.println(remark);

        return "succeed";
    }
}
