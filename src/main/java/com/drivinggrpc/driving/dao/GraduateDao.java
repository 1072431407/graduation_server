package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Graduate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GraduateDao {

    @Select("select * from graduate where state=#{state}")
    List<Graduate> selectGraduate(int state);

    @Delete("delete from graduate where user_id=#{user_id}")
    int deleteGraduateByUserId(String user_id);

    @Insert("insert into graduate(user_id,name,sex,age,phone,type,code,state) values (#{user_id},#{name},#{sex},#{age},#{phone},#{type},#{code},#{state})")
    int insertGraduate(Graduate graduate);

    @Select("select * from graduate where user_id=#{user_id}")
    Graduate selectGraduateByUserId(String user_id);
}
