package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.UserMessage;
import com.drivinggrpc.driving.server.UserServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import javafx.util.Pair;
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
    /*
    power 权限
    1 表示用户
    2 表示管理员
     */

    //-------------------------------------------------------------------------------------------

    /*
    @Controller 注解时，spring默认方法返回的是view对象（页面）。
    而加上@ResponseBody，则方法返回的就是具体对象了。
    @RestController的作用就相当于@Controller+@ResponseBody的结合体

    var a = ${state};
    console.log(a);
    alert(a);
     */

    @ResponseBody
    @PostMapping("/getVerCode")
    public String getVerCode() {
        int ran = (int) (Math.random() * (9999 - 1000)) + 1000;
        logger.info("/getVerCode:[vercode:" + ran + "]");
        return ran + "";
    }

    @ResponseBody
    @PostMapping("/forPasswordRequest")
    public String forPassword(@RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "password", required = false) String password) {
        logger.info("/forPasswordRequest:[username:" + username + ",password:" + password + "]");
        String state = userServer.modifyPassword(username, password, 2);
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
        Pair<String, Integer> pair = userServer.login(username, password);
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
        int userId = getUserId(request);
        logger.info("/userMessage:[userId:" + userId + "]");
        UserMessage message = userServer.getUserMessage(userId);
        model.addAttribute("message", message);
        return "message/user_page";
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

        UserMessage message = userServer.updateUserMessage(getUserId(request),phoneCode,nick,email,age,school,sex,city);
        model.addAttribute("message", message);
        return "message/user_page::message";
    }


    private int getUserId(HttpServletRequest request){
        Object object = request.getSession().getAttribute("userInfo");
        return Integer.parseInt(object.toString());
    }
    @ResponseBody
    @PostMapping("/loginOut")
    public void loginOut(HttpServletRequest request) {
        logger.info("/loginOut:[removeAttribute(\"userInfo\")]");
        request.getSession().removeAttribute("userInfo");
    }

}
