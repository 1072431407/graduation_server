package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Report;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ReportDao {


    @Select("select * from report")
    List<Report> selectAll();

    @Delete("delete from report where user_id=#{user_id}")
    void deleteReportByUserId(String user_id);
}
