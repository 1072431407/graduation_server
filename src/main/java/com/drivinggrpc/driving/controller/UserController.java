package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.UserMessage;
import com.drivinggrpc.driving.server.UserServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import com.drivinggrpc.driving.tools.UserHelper;
import com.drivinggrpc.driving.tools.Pair;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    private Logger logger = ApplicationTools.logger;
    @Autowired
    private UserServer userServer;

    @ResponseBody
    @RequestMapping("/sss")
    public String test() {
        return "hee";
    }

    @ResponseBody
    @GetMapping("/user/register")
    public String register(@RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "password", required = false) String password) {
        logger.info("/register:[username:" + username + ",password:" + password + "]");
        String state = userServer.userRegister(username, password, 2);
        if ("succeed".equals(state))
            return "succeed";
        else {
            return state;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/loginRequest", method = RequestMethod.POST)//
    public String login(@RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "password", required = false) String password,
                        HttpServletRequest request) {
        logger.info("/loginRequest:[username:" + username + ",password:" + password + "]");
        Pair<String, String> pair = userServer.login(username, password);
        String state = pair.getKey();
        if ("登录成功".equals(state)) {
            request.getSession().setAttribute("userInfo", pair.getValue());
            return "succeed";
        } else {
            return state;
        }
    }

    @GetMapping("/userMessage")
    public String userMessage(Model model, HttpServletRequest request) {
        int userId = UserHelper.getUserId(request);
        logger.info("/userMessage:[userId:" + userId + "]");
        UserMessage message = userServer.getUserMessage(userId);
        model.addAttribute("message", message);
        int power = UserHelper.getUserPower(request);
        if (power == 1)
            return "message/admin_user_page";
        else
            return "message/user_user_page";
    }

//    @ResponseBody
    @GetMapping("/user/updateMessage")
    public String updateMessage(@RequestParam(value = "phoneCode") String phoneCode,
                          @RequestParam(value = "nick") String nick,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "age") String age,
                          @RequestParam(value = "sex") String sex,
                          @RequestParam(value = "school") String school,
                          @RequestParam(value = "city") String city,
                          Model model,
                          HttpServletRequest request) {

        UserMessage message = userServer.updateUserMessage(UserHelper.getUserId(request),phoneCode,nick,email,age,school,sex,city);
        model.addAttribute("message", message);
        int power = UserHelper.getUserPower(request);
        if (power == 1)
            return "message/admin_user_page::message";
        else
            return "message/user_user_page::message";
    }



    @ResponseBody
    @PostMapping("/loginOut")
    public void loginOut(HttpServletRequest request) {
        logger.info("/loginOut:[removeAttribute(\"userInfo\")]");
        request.getSession().removeAttribute("userInfo");
    }

}
