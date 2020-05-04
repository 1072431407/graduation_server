package com.drivinggrpc.driving.po;

public class Topic {
    private String topic;//题目
    private String radio_a;//选项A
    private String radio_b;
    private String radio_c;
    private String radio_d;
    private int switch_radio;//我的选项
    private int correct_radio;//正确选项
    private String tips;//提示

    public void setRadio_a(String radio_a) {
        this.radio_a = radio_a;
    }

    public void setRadio_b(String radio_b) {
        this.radio_b = radio_b;
    }

    public void setRadio_c(String radio_c) {
        this.radio_c = radio_c;
    }

    public void setRadio_d(String radio_d) {
        this.radio_d = radio_d;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setCorrect_radio(int correct_radio) {
        this.correct_radio = correct_radio;
    }

    public void setSwitch_radio(int switch_radio) {
        this.switch_radio = switch_radio;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getRadio_a() {
        return radio_a;
    }

    public int getSwitch_radio() {
        return switch_radio;
    }

    public String getRadio_b() {
        return radio_b;
    }

    public String getRadio_c() {
        return radio_c;
    }

    public String getTopic() {
        return topic;
    }

    public String getRadio_d() {
        return radio_d;
    }

    public int getCorrect_radio() {
        return correct_radio;
    }

    public String getTips() {
        return tips;
    }
}
