package com.drivinggrpc.driving.po;

public class UserStatistics {
    private int user_id;
    private int minute;
    private String date;
    private int num_questions_1;
    private int accuracy_1;
    private int aver_score_1;
    private int degree_1;
    private int num_questions_4;
    private int accuracy_4;
    private int aver_score_4;
    private int degree_4;

    public int getAccuracy_1() {
        return accuracy_1;
    }

    public int getNum_questions_1() {
        return num_questions_1;
    }

    public int getAccuracy_4() {
        return accuracy_4;
    }

    public int getAver_score_1() {
        return aver_score_1;
    }

    public int getAver_score_4() {
        return aver_score_4;
    }

    public int getDegree_1() {
        return degree_1;
    }

    public int getDegree_4() {
        return degree_4;
    }

    public int getNum_questions_4() {
        return num_questions_4;
    }

    public void setAccuracy_1(int accuracy_1) {
        this.accuracy_1 = accuracy_1;
    }

    public void setAccuracy_4(int accuracy_4) {
        this.accuracy_4 = accuracy_4;
    }

    public void setNum_questions_1(int num_questions_1) {
        this.num_questions_1 = num_questions_1;
    }

    public void setAver_score_1(int aver_score_1) {
        this.aver_score_1 = aver_score_1;
    }

    public void setAver_score_4(int aver_score_4) {
        this.aver_score_4 = aver_score_4;
    }

    public void setDegree_1(int degree_1) {
        this.degree_1 = degree_1;
    }

    public void setDegree_4(int degree_4) {
        this.degree_4 = degree_4;
    }

    public void setNum_questions_4(int num_questions_4) {
        this.num_questions_4 = num_questions_4;
    }

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
