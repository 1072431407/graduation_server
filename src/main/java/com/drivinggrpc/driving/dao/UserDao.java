package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.User;
import com.drivinggrpc.driving.po.UserMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserDao {
    @Select("select id,username,password,power from user_t where username = #{username}")
    User selectUserByUserName(String username);

    @Insert("insert into user_t(username,password,power) values (#{username},#{password},#{power})")
    int insertUser(User user);

    @Select("select * from user_message_t where user_id = #{user_id}")
    UserMessage selectUserMessage(int user_id);

    @Update("update user_message_t set phoneCode = #{phoneCode},nick = #{nick},email = #{email},age = #{age},sex = #{sex},school = #{school},city = #{city} where user_id = #{user_id}")
    int updateUserMessage(UserMessage message);

    @Insert("insert into user_message_t(user_id,phoneCode,nick,email,age,sex,school,city) values (#{id},#{phoneCode},#{nick},#{email},#{age},#{sex},#{school},#{city})")
    int insertUserMessage(UserMessage newMessage);

    @Select("select * from user_message_t")
    List<UserMessage> selectUserMessageAll();
}
