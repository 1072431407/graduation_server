package com.drivinggrpc.driving.tools;

import javax.servlet.http.HttpServletRequest;

public class UserHelper {

    public static int getUserId(HttpServletRequest request){
        Object object = request.getSession().getAttribute("userInfo");
        String userInfo = object.toString();
        int userId = Integer.parseInt(userInfo.substring(0,userInfo.indexOf(",")));
        return userId;
    }

    public static int getUserPower(HttpServletRequest request){
        Object object = request.getSession().getAttribute("userInfo");
        String userInfo = object.toString();
        int power = Integer.parseInt(userInfo.substring(userInfo.indexOf(",")+1));
        return power;
    }
}
