package com.drivinggrpc.driving.tools;

import com.drivinggrpc.driving.po.Job;

public class JobCacheBean {
    private Job firstJob;
    private Job secondJob;

    public Job getFirstJob() {
        return firstJob;
    }

    public void setFirstJob(Job firstJob) {
        this.firstJob = firstJob;
    }

    public Job getSecondJob() {
        return secondJob;
    }

    public void setSecondJob(Job secondJob) {
        this.secondJob = secondJob;
    }

    public void clear(){
        firstJob = null;
        secondJob = null;
    }
}
