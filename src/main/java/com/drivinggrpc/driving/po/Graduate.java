package com.drivinggrpc.driving.po;

/**
 * 毕业人员state=0  黑名单state=1
 */
public class Graduate {
    private String user_id;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private String type;
    private String code;
    private int state;

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

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
