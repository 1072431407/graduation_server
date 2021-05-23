package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.tools.UserHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JumpController {
    @GetMapping("/login")
    public String index(){
        return "index";
    }
    @GetMapping("/forget-password")
    public String forget_password(){
        return "register";
    }
    @GetMapping("/main")
    public String main(HttpServletRequest request){
        int power = UserHelper.getUserPower(request);
        if (power == 1)
            return "admin_main";
        else
            return "user_main";
    }
    @GetMapping("/jobAdd")
    public String jobAdd(HttpServletRequest request){
        int power = UserHelper.getUserPower(request);
        if (power == 1)
            return "sys/admin_add_job";
        else
            return "sys/user_add_job";
    }

}
