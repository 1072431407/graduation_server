package com.drivinggrpc.driving.controller;

import com.drivinggrpc.driving.po.UserMessage;
import com.drivinggrpc.driving.rpc.proto.user.*;
import com.drivinggrpc.driving.server.UserServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    private Logger logger = ApplicationTools.logger;
    @Autowired
    private UserServer userServer;
    /*
    power 权限
    1 表示用户
    2 表示管理员
     */
    public loginResponse userLogin(String username, String password, int power){
        String state = userServer.login(username,password,power);
        loginResponse response = loginResponse.newBuilder()
                .setState(state)
                .build();
        logger.info("user login:"+username+","+password+"-->"+state);
        return response;
    }
/*
    注册成功
    该账号已存在
*/
    public registerResponse userRegister(String username, String password, int power) {
        String state = userServer.userRegister(username,password,power);
        registerResponse response = registerResponse.newBuilder()
                .setState(state)
                .build();
        logger.info("user register:"+username+","+password+","+power+"-->"+state);
        return response;
    }
/*
    密码找回成功
    密码找回失败
    用户不存在
    您没有权限操作该账号
*/
    public upPasswordResponse upUserPassword(String username, String password) {
        String state = userServer.modifyPassword(username,password,1);
        upPasswordResponse response = upPasswordResponse.newBuilder()
                .setState(state).build();
        logger.info("user modify password:"+username+","+password+"-->"+state);
        return response;
    }
/*
        getUserMessageResponse response = getUserMessageResponse.newBuilder()
                .setUserId(1)
                .setHeadImage("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1391960522,3944688945&fm=15&gp=0.jpg")
                .setNickName("甲鱼")
                .setSignature("算无遗策")
                .setDate("2018-9-2")
                .setMinute(63)

                .setName("张三")
                .setPhone("15104343050")
                .setSex("男")
                .setAge("26")
                .setJob("学生")
                .setQqCode("1072431407")
                .setWeChat("15104343050")
                .setEMail("1072431407@qq.com")
                .build();
 */
    public getUserMessageResponse getUserMessageByUserName(String userName) {
        UserMessage userMessage = userServer.getUserMessageByUserName(userName);
        getUserMessageResponse response = getUserMessageResponse.newBuilder()
                .setUserId(userMessage.getUser_id())
                .setHeadImage(userMessage.getHead_image())
                .setNickName(userMessage.getNick_name())
                .setSignature(userMessage.getSignature())
                .setMinute(userMessage.getMinute())
                .setDate(userMessage.getDate())
                .setName(userMessage.getName())
                .setPhone(userMessage.getPhone())
                .setSex(userMessage.getSex())
                .setAge(userMessage.getAge())
                .setJob(userMessage.getJob())
                .setQqCode(userMessage.getQq_code())
                .setWeChat(userMessage.getWe_chat())
                .setEMail(userMessage.getE_mail())
                .build();
        logger.info("user get UserMessage:"+"--> value="+userName);
        return response;
    }

/*
    int32 user_id = 1;
    string head_image = 2;
    string nick_name = 3;
    string signature = 4;//签名
    int32 minute = 5;
    string date = 6;//报名日期
    string name = 7;
    string phone = 8;
    string sex = 9;
    string age = 10;
    string job = 11;
    string qq_code = 12;
    string we_chat = 13;
    string e_mail = 14;
 */
/*
    保存成功
    保存失败
*/
    public setUserMessageResponse setUserMessage(setUserMessageRequest request, String headImage) {
        UserMessage userMessage = new UserMessage();
        userMessage.setUser_id(request.getUserId());
        userMessage.setHead_image(headImage);
        userMessage.setNick_name(request.getNickName());
        userMessage.setSignature(request.getSignature());
        userMessage.setMinute(request.getMinute());
        userMessage.setDate(request.getDate());
        userMessage.setName(request.getName());
        userMessage.setPhone(request.getPhone());
        userMessage.setSex(request.getSex());
        userMessage.setAge(request.getAge());
        userMessage.setJob(request.getJob());
        userMessage.setQq_code(request.getQqCode());
        userMessage.setWe_chat(request.getWeChat());
        userMessage.setE_mail(request.getEMail());


        String state = userServer.setUserMessageByUserId(userMessage);
        setUserMessageResponse response = setUserMessageResponse.newBuilder().setState(state).build();
        logger.info("user set UserMessage:"+"-->"+state);
        return response;
    }

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
    public String getVerCode(){
        int ran = (int)(Math.random()*(9999-1000))+1000;
        logger.info("/getVerCode:[vercode:"+ran+"]");
        return ran+"";
    }

    @ResponseBody
    @PostMapping("/forPasswordRequest")
    public String forPassword(@RequestParam(value = "username",required = false) String username,
                              @RequestParam(value = "password",required = false) String password){
        logger.info("/forPasswordRequest:[username:"+username+",password:"+password+"]");
        String state = userServer.modifyPassword(username,password,2);
        if ("succeed".equals(state))
            return "succeed";
        else{
            return state;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/loginRequest",method = RequestMethod.POST)//
    public String rootLogin(@RequestParam(value = "username",required = false) String username,
                            @RequestParam(value = "password",required = false) String password,
                            HttpServletRequest request){
        logger.info("/loginRequest:[username:"+username+",password:"+password+"]");
        String state = userServer.login(username,password,2);
        if ("登录成功".equals(state)) {
            request.getSession().setAttribute("userInfo",username+","+password);
            return "succeed";
        }else {
            return state;
        }
    }

    @ResponseBody
    @PostMapping("/loginOut")
    public void loginOut(HttpServletRequest request){
        logger.info("/loginOut:[removeAttribute(\"userInfo\")]");
        request.getSession().removeAttribute("userInfo");
    }

}
