package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.Job;
import com.drivinggrpc.driving.server.JobServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import com.drivinggrpc.driving.tools.ContrastJobCache;
import com.drivinggrpc.driving.tools.UserHelper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class JobController {
    private Logger logger = ApplicationTools.logger;
    @Autowired
    private JobServer jobServer;

    @ResponseBody
    @GetMapping("/job/check")
    public Job checkJob(@RequestParam(value = "job_id") String job_id) {
        Job exam = jobServer.selectJobById(Integer.parseInt(job_id));
        logger.info("/job/check" + job_id);
        return exam;
    }

    @GetMapping("/jobAll")
    public String jobAll(Model model, HttpServletRequest request) {
        List<Job> list = jobServer.selectJobAll();
        model.addAttribute("jobs", list);
        int power = UserHelper.getUserPower(request);
        if (power == 1)
            return "job/admin_job_all";
        else
            return "job/user_job_all";
    }

    @GetMapping("/jobAdmin")
    public String jobAdmin(Model model, HttpServletRequest request) {
        List<Job> list = jobServer.selectJobAll();
        model.addAttribute("jobs", list);
        int power = UserHelper.getUserPower(request);
        if (power == 1)
            return "sys/admin_job_admin";
        else
            return "sys/user_job_admin";
    }

    @GetMapping("/job/delete")
    public String jobDelete(@RequestParam(value = "job_id") String job_id, Model model, HttpServletRequest request) {
        jobServer.deleteJob(Integer.parseInt(job_id));
        List<Job> list = jobServer.selectJobAll();
        model.addAttribute("jobs", list);
        int power = UserHelper.getUserPower(request);
        if (power == 1)
            return "sys/admin_job_admin::table";
        else
            return "sys/user_job_admin::table";
    }

    @ResponseBody
    @GetMapping("/job/add")
    public String jobAdd(@RequestParam(value = "name") String name,
                         @RequestParam(value = "industry") String industry,
                         @RequestParam(value = "money") String money,
                         @RequestParam(value = "hotCity") String hotCity,
                         @RequestParam(value = "content") String content,
                         @RequestParam(value = "direction") String direction) {
        Job job = new Job();
        job.setName(name);
        job.setIndustry(industry);
        job.setMoney(money);
        job.setHotCity(hotCity);
        job.setContent(content);
        job.setDirection(direction);
        return jobServer.addJob(job);
    }


    @GetMapping("/jobContrast")
    public String jobContrast(Model model, HttpServletRequest request) {
        List<Job> list = jobServer.selectJobAll();
        model.addAttribute("jobs", list);
        int power = UserHelper.getUserPower(request);
        if (power == 1)
            return "job/admin_job_contrast";
        else
            return "job/user_job_contrast";
    }

    @ResponseBody
    @GetMapping("/job/contrast")
    public Job contrastJob(@RequestParam(value = "job_id") String job_id, Model model, HttpServletRequest request) {
        int userId = UserHelper.getUserId(request);
        Job exam = jobServer.selectJobById(Integer.parseInt(job_id));
        logger.info("/job/check" + job_id);
        Job result = ContrastJobCache.contrast(userId, exam);
        model.addAttribute("showDialog", result != null);
        return result;
    }
}
