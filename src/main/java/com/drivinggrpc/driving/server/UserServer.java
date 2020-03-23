package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.UserMessage;

public interface UserServer {
    String login(String username, String password, int power);

    String modifyPassword(String username, String password, int power);

    String userRegister(String username, String password, int power);

    UserMessage getUserMessageByUserName(String userName);

    String setUserMessageByUserId(UserMessage userMessage);
}
