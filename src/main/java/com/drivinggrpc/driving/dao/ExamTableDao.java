package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Exam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ExamTableDao {
    @Select("select * from exam_table where state=#{state}")
    List<Exam> selectExamByState(int state);

    @Select("select * from exam_table where exam_id=#{exam_id}")
    Exam selectExamByExamId(String exam_id);

    @Delete("delete from exam_table where exam_id=#{exam_id}")
    void deleteExamByExamId(String exam_id);

    @Insert("insert into exam_table(exam_id,type,data,time,max,address,remark,state) values (#{exam_id},#{type},#{data},#{time},#{max},#{address},#{remark},#{state})")
    int insertExam(Exam exam);
}
