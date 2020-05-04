package com.drivinggrpc.driving.po;

/**
 * 账单
 */
public class Bill {
    private String user_id;
    private long date;
    private int money;
    private String cause;//缴费原因
    private int id;
    private int state;//状态

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getMoney() {
        return money;
    }

    public long getDate() {
        return date;
    }

    public String getCause() {
        return cause;
    }
}
