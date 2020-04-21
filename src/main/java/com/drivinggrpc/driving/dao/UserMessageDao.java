package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.UserMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMessageDao {
    @Select("select * from user_message where user_id = #{user_id}")
    UserMessage selectMessageByUserId(String user_id);

    int modifyUserMessageByUserId(UserMessage message);
}
