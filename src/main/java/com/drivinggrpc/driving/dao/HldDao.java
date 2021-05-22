package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.HLD;
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
public interface HldDao {
    @Select("select * from hwd_t")
    List<HLD> selectAll();
}
