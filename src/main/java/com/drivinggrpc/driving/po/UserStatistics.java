package com.drivinggrpc.driving.po;

public class UserStatistics {
    private int user_id;
    private int minute;
    private String date;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getMinute() {
        return minute;
    }

    public String getDate() {
        return date;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
