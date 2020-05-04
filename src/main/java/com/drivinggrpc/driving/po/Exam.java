package com.drivinggrpc.driving.po;

import java.util.List;

public class Exam {
    private String exam_id;//考试的UUID
    private String type;//考试类型
    private String data;//考试日期
    private String time;//考试时间
    private int max;//考试最大人数
    private int num;//当前报名人数
    private String address;//考试地址
    private String remark;//备注
    private int duration;//时长（分钟）
    private int state;//0代表考试 1代表练车
    private String type_code;//驾驶证件类型

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public String getType_code() {
        return type_code;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getState() {
        return state;
    }

    public int getDuration() {
        return duration;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public int getMax() {
        return max;
    }

    public String getData() {
        return data;
    }

    public String getExam_id() {
        return exam_id;
    }

}
