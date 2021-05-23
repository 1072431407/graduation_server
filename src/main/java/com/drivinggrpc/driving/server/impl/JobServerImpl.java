package com.drivinggrpc.driving.server.impl;


import com.drivinggrpc.driving.dao.JobDao;
import com.drivinggrpc.driving.po.Job;
import com.drivinggrpc.driving.server.JobServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServerImpl implements JobServer {

    @Autowired
    private JobDao jobDao;

    @Override
    public Job selectJobById(int jobId) {
        return jobDao.selectJobById(jobId);
    }

    @Override
    public List<Job> selectJobAll() {
        return jobDao.selectJob();
    }

    @Override
    public void deleteJob(int job_id) {
        jobDao.deleteJob(job_id);
    }

    @Override
    public String addJob(Job job) {
        try {
            int index = jobDao.insertJob(job);
            if (index > 0)
                return "succeed";
            return "添加失败";
        }catch (Exception e){
            return "添加失败";
        }
    }
}
