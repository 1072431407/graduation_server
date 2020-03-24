package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserDao {
    @Select("select id,username,password,power from user where username = #{username}")
    User selectUserByUserName(String username);

    @Update("update user set password = #{password} where username = #{username}")
    int modifyPasswordByUserName(User user);

    @Insert("insert into user(username,password,power) values (#{username},#{password},#{power})")
    int insertUser(User user);
}
