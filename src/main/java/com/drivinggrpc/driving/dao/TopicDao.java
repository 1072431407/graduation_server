package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TopicDao {
    @Select("select * from topic_table where type = #{type}")
    List<Topic> selectTopicByType(String type);
}
