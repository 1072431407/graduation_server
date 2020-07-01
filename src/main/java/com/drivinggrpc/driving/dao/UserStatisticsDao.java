package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.UserStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserStatisticsDao {
    @Select("select date from user_statistics where user_id = #{user_id}")
    String selectUserApplyDateByUserId(String user_id);

    @Select("select user_id,date,minute from user_statistics where user_id = #{user_id}")
    UserStatistics selectUserStatisticsByUserId(String user_id);

    @Update("update user_statistics set date=#{date} where user_id=#{user_id}")
    int updateToDateByUserId(UserStatistics statistics);

    @Select("select * from user_statistics where user_id = #{user_id}")
    UserStatistics selectUserStatisticsAllByUserId(String user_id);

    @Update("update user_statistics set num_questions_1=#{num_questions_1} where user_id=#{userId}")
    void updateNum1(int num_questions_1, String userId);

    @Update("update user_statistics set accuracy_1=#{accuracy_1} where user_id=#{userId}")
    void updateAcc1(int accuracy_1, String userId);

    @Update("update user_statistics set num_questions_4=#{num_questions_4} where user_id=#{userId}")
    void updateNum4(int num_questions_4, String userId);

    @Update("update user_statistics set accuracy_4=#{accuracy_4} where user_id=#{userId}")
    void updateAcc4(int accuracy_4, String userId);

    @Update("update user_statistics set aver_score_1=#{aver_score_1} where user_id=#{userId}")
    void updateAve1(int aver_score_1, String userId);

    @Update("update user_statistics set degree_1=#{degree_1} where user_id=#{userId}")
    void updateDeg1(int degree_1, String userId);

    @Update("update user_statistics set aver_score_4=#{aver_score_4} where user_id=#{userId}")
    void updateAve4(int aver_score_4, String userId);

    @Update("update user_statistics set degree_4=#{degree_4} where user_id=#{userId}")
    void updateDeg4(int degree_4, String userId);

    @Select("select minute from user_statistics where user_id = #{user_id}")
    int selectMinute(String user_id);

    @Update("update user_statistics set minute=#{minute} where user_id=#{user_id}")
    void updataMinute(long minute, String user_id);
}
