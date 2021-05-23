package com.drivinggrpc.driving.tools;

import com.drivinggrpc.driving.po.Job;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ContrastJobCache {
    private final static ConcurrentMap<Integer, Job> cache = new ConcurrentHashMap<>();

    public static Job contrast(int userId, Job job) {
        Job jobCache;
        if (cache.containsKey(userId)) {
            jobCache = cache.get(userId);
            Job result = getContrast(jobCache, job);
            cache.remove(userId);
            return result;
        } else {
            jobCache = job.clone();
            cache.put(userId, jobCache);
            return null;
        }

    }

    public static void clear(int userId){
        cache.remove(userId);
    }

    private static Job getContrast(Job job1, Job job2) {
        Job contrast = new Job();
        contrast.setName(job1.getName()+"--"+job2.getName());
        contrast.setIndustry(job1.getIndustry()+"--"+job2.getIndustry());
        contrast.setMoney(job1.getMoney()+"--"+job2.getMoney());
        contrast.setHotCity(job1.getHotCity()+"--"+job2.getHotCity());
        contrast.setContent(job1.getContent()+"--"+job2.getContent());
        contrast.setDirection(job1.getDirection()+"--"+job2.getDirection());
        return contrast;
    }
}
