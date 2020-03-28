package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Absentee;
import com.drivinggrpc.driving.po.UserApply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AbsenteeDao {
    @Select("select * from absentee")
    List<UserApply> selectAbsenteeAll();

    @Select("select * from absentee where user_id = #{user_id}")
    List<UserApply> selectAbsenteeByUserId(int user_id);

    @Insert("insert into absentee(user_id,picture,name,sex,age,address,phone,old_type,type) values (#{user_id},#{picture},#{name},#{sex},#{age},#{address},#{phone},#{old_type},#{type})")
    int insertUserAbsentee(UserApply apply);
}
