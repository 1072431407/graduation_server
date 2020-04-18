package com.drivinggrpc.driving.po;

public class Graduate {
    private int user_id;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private String type;
    private String code;
    private int state;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUser_id() {
        return user_id;
    }


    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public String getType() {
        return type;
    }
}
