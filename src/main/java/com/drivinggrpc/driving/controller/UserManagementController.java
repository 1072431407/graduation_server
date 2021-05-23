package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.Job;
import com.drivinggrpc.driving.po.UserMessage;
import com.drivinggrpc.driving.server.UserServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
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
public class UserManagementController {

    private Logger logger = ApplicationTools.logger;
    @Autowired
    private UserServer userServer;

    @GetMapping("/userAdmin")
    public String jobAdmin(Model model, HttpServletRequest request) {
        List<UserMessage> list = userServer.selectUserMessageAll();
        model.addAttribute("users", list);
        int power = UserHelper.getUserPower(request);
        if (power == 1)
            return "sys/admin_user_admin";
        else
            return "sys/user_job_admin";
    }

    @ResponseBody
    @GetMapping("/user/message")
    public UserMessage checkJob(@RequestParam(value = "user_id") String user_id) {
        UserMessage userMessage = userServer.getUserMessage(Integer.parseInt(user_id));
        logger.info("/job/check" + user_id);
        return userMessage;
    }
}
