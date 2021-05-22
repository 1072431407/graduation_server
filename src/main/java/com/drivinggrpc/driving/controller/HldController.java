package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.HLD;
import com.drivinggrpc.driving.po.UserMessage;
import com.drivinggrpc.driving.server.HldServer;
import com.drivinggrpc.driving.server.UserServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import com.drivinggrpc.driving.tools.HldCache;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class HldController {
    private Logger logger = ApplicationTools.logger;
    @Autowired
    private HldServer hldServer;

    @GetMapping("/hld")
    public String hld(Model model, HttpServletRequest request) {
        int userId = getUserId(request);
        int index = HldCache.flush(userId);
        HLD hld;
        if (index > 0 && index <= HldCache.HLD_TIME) {
            hld= hldServer.getHld();
            if (index == HldCache.HLD_TIME)
                hld.setButton("提交");
            else
                hld.setButton("下一题");
            HldCache.put(userId, hld.getId());
        } else {
            hld = new HLD();
            hld.setTitle("当前已完成测试，过些日子再来吧");
        }
        model.addAttribute("hld", hld);
        return "message/hld_exam";
    }

    @GetMapping("/hld/next")
    public String updateMessage(@RequestParam(value = "change") String change,
                                Model model,
                                HttpServletRequest request) {
        int userId = getUserId(request);
        HldCache.put(userId, change);
        int index = HldCache.flush(userId);
        if (index > 0 && index <= HldCache.HLD_TIME) {
            HLD hld = hldServer.getHld();
            if (index == HldCache.HLD_TIME)
                hld.setButton("提交");
            else
                hld.setButton("下一题");

            model.addAttribute("hld", hld);
        }else {
            HLD hld = new HLD();
            Map<Integer,String> answer = HldCache.getAnswer(userId);
            if (answer.size() > 0){
                // TODO: 2021/5/22 结果
                hld.setQuestion("当前已完成测试，过些日子再来吧");
                hld.setAnswer1("当前已完成测试，过些日子再来吧");
                hld.setAnswer2("当前已完成测试，过些日子再来吧");
                HldCache.cleanAnswer(userId);
            } else {
                hld.setTitle("当前已完成测试，过些日子再来吧");
            }

            model.addAttribute("hld", hld);
        }
        return "message/hld_exam::exam";
    }

    private int getUserId(HttpServletRequest request) {
        Object object = request.getSession().getAttribute("userInfo");
        return Integer.parseInt(object.toString());
    }
}
