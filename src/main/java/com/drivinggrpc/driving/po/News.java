package com.drivinggrpc.driving.po;

public class News {
    private String user_id;
    private String title;
    private String content;
    private String date;
    private int state;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
