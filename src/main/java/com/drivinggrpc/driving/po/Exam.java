package com.drivinggrpc.driving.po;

public class Exam {
    private String exam_id;
    private String type;
    private String data;
    private int max;
    private String address;
    private String remark;

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
