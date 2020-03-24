package com.drivinggrpc.driving.tools;

import com.drivinggrpc.driving.DrivingApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://github.com/1072431407/graduation_server.git
 * git remote add origin {url}
 * git pull origin master
 */
public class ApplicationTools {
    private static String SERVER_IP =  "192.168.3.36";
    public static Logger logger = LoggerFactory.getLogger(DrivingApplication.class);

    public static final String HEAD_IMAGE = "src/main/resources/static/androidImage/";
    public static final String PICTURE_IMAGE = "src/main/resources/static/images/pictures/";
//    public static String HEAD_IMAGE = "C:\\Work\\Idea_Work\\driving-springboot\\src\\main\\resources\\static\\androidImage/head";

//    public static String http://192.168.3.36:8080/androidImage/head_image.png
    public static String getHeadImage(String newFileName){
        return  "http://"+SERVER_IP+":8080/androidImage/"+newFileName+".jpg";
    }
}
