package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Topic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TopicDao {
    @Select("select * from topic_table where type = #{type}")
    List<Topic> selectTopicByType(String type);

    @Insert("insert into topic_table(topic,radio_a,radio_b,radio_c,radio_d,correct_radio,tips,type) value(#{topic},#{radio_a},#{radio_b},#{radio_c},#{radio_d},#{correct_radio},#{tips},#{type})")
    int insertTopic(Topic bean);

    @Select("select * from topic_table")
    List<Topic> selectTopicAll();

    @Select("select * from topic_table where id= #{id}")
    Topic selectTopicById(int id);

    @Delete("delete from topic_table where id=#{id}")
    void deleteTopicById(int id);
}
