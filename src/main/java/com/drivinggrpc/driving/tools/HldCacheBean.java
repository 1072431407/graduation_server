package com.drivinggrpc.driving.tools;

import java.util.HashMap;
import java.util.Map;

public class HldCacheBean {
    private int time;
    private long recode;
    private Map<Integer, String> answer = new HashMap<>();

    public HldCacheBean() {

    }

    public HldCacheBean(int time, long recode) {
        this.time = time;
        this.recode = recode;
    }

    public Map<Integer, String> getAnswer() {
        return answer;
    }

    public void put(int id, String answer) {
        this.answer.put(id, answer);
    }

    public void flushTime() {
        time++;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public long getRecode() {
        return recode;
    }

    public void setRecode(long recode) {
        this.recode = recode;
    }

    public void clearAnswer() {
        answer.clear();
    }
}
