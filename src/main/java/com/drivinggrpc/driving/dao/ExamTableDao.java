package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Exam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ExamTableDao {
    @Select("select * from exam_table where state=#{state}")
    List<Exam> selectExamByState(int state);

    @Select("select * from exam_table where type=#{type} and state = #{state}")
    List<Exam> selectExamByType(String type,int state);

    @Select("select * from exam_table where exam_id=#{exam_id}")
    Exam selectExamByExamId(String exam_id);

    @Delete("delete from exam_table where exam_id=#{exam_id}")
    int deleteExamByExamId(String exam_id);

    @Insert("insert into exam_table(exam_id,type,data,time,max,address,remark,state,type_code) values (#{exam_id},#{type},#{data},#{time},#{max},#{address},#{remark},#{state},#{type_code})")
    int insertExam(Exam exam);

    @Update("update exam_table set num = #{num} where exam_id = #{exam_id}")
    int updateExamNumByExamId(String exam_id,int num);

    @Select("select num from exam_table where exam_id=#{exam_id}")
    int selectExamNumByExamId(String exam_id);

    @Select("select max from exam_table where exam_id=#{exam_id}")
    int selectExamMaxByExamId(String exam_id);

    @Select("select type_code from exam_table where exam_id=#{examId}")
    String selectTypeByExamId(String examId);
}
