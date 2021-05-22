package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.UserMessage;
import javafx.util.Pair;

import javax.validation.constraints.NotNull;

public interface UserServer {
    Pair<String, Integer> login(String username, String password);

    String modifyPassword(String username, String password, int power);

    String userRegister(String username, String password, int power);

    @NotNull
    UserMessage getUserMessage(int userId);

    UserMessage updateUserMessage(int userId, String phoneCode, String nick, String email, String age, String school, String sex, String city);
}
