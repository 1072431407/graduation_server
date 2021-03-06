package com.drivinggrpc.driving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JumpController {
    @GetMapping("/login")
    public String index(){
        return "index";
    }
    @GetMapping("/forget-password")
    public String forget_password(){
        return "forget-password";
    }
    @GetMapping("/main")
    public String main(){
        return "main";
    }
    @GetMapping("/addExam")
    public String addExam(){
        return "list2/list2_0";
    }
    @GetMapping("/addExercise")
    public String addExercise(){
        return "list2/list2_3";
    }
    @GetMapping("/addExamination")
    public String addExamination(){
        return "list3/list3_0";
    }
}
