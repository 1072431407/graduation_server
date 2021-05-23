package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Job;
import com.drivinggrpc.driving.po.User;
import com.drivinggrpc.driving.po.UserMessage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface JobDao {
    @Select("select * from job_t where job_id = #{jobId}")
    Job selectJobById(int jobId);

    @Select("select * from job_t")
    List<Job> selectJob();

    @Delete("delete from job_t where job_id = #{jobId}")
    void deleteJob(int jobId);

    @Insert("insert into job_t(name,industry,money,hotCity,content,direction) values (#{name},#{industry},#{money},#{hotCity},#{content},#{direction})")
    int insertJob(Job job);
}
