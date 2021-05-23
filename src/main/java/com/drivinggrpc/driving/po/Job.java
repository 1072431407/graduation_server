package com.drivinggrpc.driving.po;

public class Job {
    private int job_id;
    private String name;//职位名称
    private String industry;//行业
    private String money;//薪资范围
    private String hotCity;//热门城市
    private String content;//内容
    private String direction;//技能

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getHotCity() {
        return hotCity;
    }

    public void setHotCity(String hotCity) {
        this.hotCity = hotCity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
