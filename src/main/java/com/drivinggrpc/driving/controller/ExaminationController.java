package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.Report;
import com.drivinggrpc.driving.po.Topic;
import com.drivinggrpc.driving.server.ExaminationServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExaminationController {
    @Autowired
    private ExaminationServer examinationServer;
    @GetMapping("/removeExamination")
    public String initExamination(Model model){
        List<Topic> listBeans = examinationServer.initExamination();
        model.addAttribute("topics",listBeans);
        return "list3/list3_1";
    }
    @GetMapping("/removeExamination/remove")
    public String removeExamination(@RequestParam(value = "id")int id,Model model){
        examinationServer.removeExamination(id);
        List<Topic> listBeans = examinationServer.initExamination();
        model.addAttribute("topics",listBeans);
        return "list3/list3_1::list";
    }

    @ResponseBody
    @GetMapping("/removeExamination/check")
    public Topic checkExamination(@RequestParam(value = "id")int id,Model model){
        Topic topic = examinationServer.checkExamination(id);
        return topic;
    }

    @ResponseBody
    @GetMapping("/removeExamination/addTopic")
    public String addTopic(@RequestParam(value = "type")String type,
                           @RequestParam(value = "correct_radio")int correct_radio,
                           @RequestParam(value = "topic")String topic,
                           @RequestParam(value = "radio_a")String radio_a,
                           @RequestParam(value = "radio_b")String radio_b,
                           @RequestParam(value = "radio_c")String radio_c,
                           @RequestParam(value = "radio_d")String radio_d,
                           @RequestParam(value = "tips")String tips){
        Topic bean = new Topic();
        bean.setCorrect_radio(correct_radio);
        bean.setType(type);
        bean.setTopic(topic);
        bean.setRadio_a(radio_a);
        bean.setRadio_b(radio_b);
        bean.setRadio_c(radio_c);
        bean.setRadio_d(radio_d);
        bean.setTips(tips);
        boolean key = examinationServer.addTopic(bean);
        if (key)
            return "succeed";
        else
            return "fail";
    }

}
