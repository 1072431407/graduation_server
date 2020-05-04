package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Report;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ReportDao {


    @Select("select * from report where state=#{state}")
    List<Report> selectAllByState(int state);

    @Delete("delete from report where user_id=#{user_id}")
    void deleteReportByUserId(String user_id);

    @Insert("insert into report(user_id,exam_id,apply_time,state) values (#{user_id},#{exam_id},#{apply_time},#{state})")
    int insertReport(Report report);

    @Select("select * from report where user_id=#{user_id} and exam_id=#{exam_id}")
    Report selectReport(String user_id,String exam_id);

    @Delete("delete from report where exam_id=#{exam_id}")
    void deleteReportByExamId(String exam_id);
}
