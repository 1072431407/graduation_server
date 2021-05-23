package com.drivinggrpc.driving.server.impl;


import com.drivinggrpc.driving.dao.UserDao;
import com.drivinggrpc.driving.po.User;
import com.drivinggrpc.driving.po.UserMessage;
import com.drivinggrpc.driving.server.UserServer;
import com.drivinggrpc.driving.tools.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServerImpl implements UserServer {
    @Autowired
    private UserDao userDao;

    @Override
    public Pair<String, String> login(String username, String password) {
        User user = userDao.selectUserByUserName(username);
        if (user == null)
            return new Pair<>("用户不存在", "null");
        if (password.equals(user.getPassword()))
            return new Pair<>("登录成功", user.getId() + "," + user.getPower());
        else
            return new Pair<>("密码错误", "null");
    }

    /**
     * 注册成功
     * 该账号已存在
     */
    @Override
    public String userRegister(String username, String password, int power) {
        User user = userDao.selectUserByUserName(username);
        if (user != null)
            return "该账号已存在";
        else {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setPower(power);
            int key = userDao.insertUser(newUser);
            if (key > 0)
                return "succeed";
            else
                return "注册失败";
        }
    }

    @Override
    public UserMessage getUserMessage(int userId) {
        UserMessage message = userDao.selectUserMessage(userId);
        if (message == null) message = new UserMessage();
        return message;
    }

    @Override
    public UserMessage updateUserMessage(int userId, String phoneCode, String nick, String email, String age, String school, String sex, String city) {
        UserMessage message = userDao.selectUserMessage(userId);
        UserMessage newMessage = new UserMessage();
        newMessage.setAge(age);
        newMessage.setCity(city);
        newMessage.setEmail(email);
        newMessage.setUser_id(userId);
        newMessage.setNick(nick);
        newMessage.setPhoneCode(phoneCode);
        newMessage.setSchool(school);
        newMessage.setSex(sex);
        if (message == null) {
            userDao.insertUserMessage(newMessage);
        } else {
            userDao.updateUserMessage(newMessage);
        }
        return newMessage;
    }

    @Override
    public List<UserMessage> selectUserMessageAll() {
        return userDao.selectUserMessageAll();
    }

}
