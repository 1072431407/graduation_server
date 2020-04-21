package com.drivinggrpc.driving.server.impl;



import com.drivinggrpc.driving.dao.UserDao;
import com.drivinggrpc.driving.dao.UserMessageDao;
import com.drivinggrpc.driving.dao.UserStatisticsDao;
import com.drivinggrpc.driving.po.User;
import com.drivinggrpc.driving.po.UserMessage;
import com.drivinggrpc.driving.po.UserStatistics;
import com.drivinggrpc.driving.server.UserServer;
import com.drivinggrpc.driving.tools.ApplicationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements UserServer {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMessageDao userMessageDao;

    @Autowired
    private UserStatisticsDao statisticsDao;
    @Override
    public String login(String username, String password, int power) {
        User user = userDao.selectUserByUserName(username);
        if (user == null)
            return "用户不存在";
        if (power != user.getPower())http://www.siping.gov.cn/fw/jyxx/
            return "你没有权限登录该账号";

        if (password.equals(user.getPassword()))
            return "登录成功";
        else
            return "密码错误";
    }

    @Override
    public String modifyPassword(String username, String password, int power) {
        User user = userDao.selectUserByUserName(username);
        if (user == null)
            return "用户不存在";
        if (user.getPower()!=power)
            return "您没有权限操作该账号";
        user.setPassword(password);
        int key = userDao.modifyPasswordByUserName(user);
        if (key>0)
            return "succeed";
        else
            return "找回密码失败";
    }
    /*
        注册成功
        该账号已存在
    */
    @Override
    public String userRegister(String username, String password, int power) {
        User user = userDao.selectUserByUserName(username);
        if (user!=null)
            return "该账号已存在";
        else{
            User newUser = new User();
            newUser.setId(ApplicationTools.getUUID());
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setPower(power);
            int key = userDao.insertUser(newUser);
            if (key>0)
                return "注册成功";
            else
                return "注册失败";
        }
    }

    @Override
    public UserMessage getUserMessageByUserName(String userName) {
        User user = userDao.selectUserByUserName(userName);
        UserMessage userMessage = userMessageDao.selectMessageByUserId(user.getId());
        UserStatistics userStatistics = statisticsDao.selectUserStatisticsByUserId(user.getId());
        userMessage.setDate(userStatistics.getDate());
        userMessage.setMinute(userStatistics.getMinute());
        return userMessage;
    }
    /*
        保存成功
        保存失败
    */
    @Override
    public String setUserMessageByUserId(UserMessage userMessage) {
        int key = userMessageDao.modifyUserMessageByUserId(userMessage);
        if (key>0)
            return "保存成功";
        else
            return "保存失败";
    }
}
