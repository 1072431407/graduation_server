package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.UserMessage;
import javafx.util.Pair;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserServer {
    Pair<String, String> login(String username, String password);

    String userRegister(String username, String password, int power);

    @NotNull
    UserMessage getUserMessage(int userId);

    UserMessage updateUserMessage(int userId, String phoneCode, String nick, String email, String age, String school, String sex, String city);

    List<UserMessage> selectUserMessageAll();

}
