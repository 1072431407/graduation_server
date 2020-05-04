package com.drivinggrpc.driving.po;

/**
 * 成绩录入
 */
public class Report {
    private String exam_id;
    private String user_id;
    private long apply_time;
    private String name;
    private String type;
    private String data;
    private String time;
    private String address;
    private int state;

    public long getApply_time() {
        return apply_time;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setApply_time(long apply_time) {
        this.apply_time = apply_time;
    }

    public int getState() {
        return state;
    }

    public void setApplyTime(long applyTime) {
        this.apply_time = applyTime;
    }

    public long getApplyTime() {
        return apply_time;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getTime() {
        return time;
    }

    public String getExam_id() {
        return exam_id;
    }

    public String getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
