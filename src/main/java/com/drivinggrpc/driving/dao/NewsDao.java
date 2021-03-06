package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface NewsDao {

    @Select("select * from news where user_id=#{user_id}")
    List<News> selectNewsByUserId(String user_id);

    @Insert("insert into news(user_id,title,content,date) value(#{user_id},#{title},#{content},#{date})")
    int insertNews(News news);

    @Update("update news set state = #{state} where id = #{id}")
    void updateStateById(int id,int state);
}
