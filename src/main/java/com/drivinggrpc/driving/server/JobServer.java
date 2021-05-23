package com.drivinggrpc.driving.server;


import com.drivinggrpc.driving.po.Job;

import java.util.List;

public interface JobServer {

    Job selectJobById(int jobId);

    List<Job> selectJobAll();

    void deleteJob(int job_id);

    String addJob(Job job);
}
