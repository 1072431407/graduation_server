package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.UserApply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserApplyDao {

    @Insert("insert into user_apply(user_id,picture,name,sex,age,address,phone,old_type,type) values (#{user_id},#{picture},#{name},#{sex},#{age},#{address},#{phone},#{old_type},#{type})")
    int insertUserApply(UserApply apply);

    @Delete("delete from user_apply where user_id=#{user_id}")
    int deleteUserApplyByUserId(int user_id);

    @Select("select state from apply_state where user_id=#{user_id}")
    String selectApplyStateByUserId(int user_id);

    @Update("update apply_state set state=#{state} where user_id=#{user_id}")
    int updateApplyStateByUserId(int user_id,String state);
}
