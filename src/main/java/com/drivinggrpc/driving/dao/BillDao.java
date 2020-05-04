package com.drivinggrpc.driving.dao;

import com.drivinggrpc.driving.po.Bill;
import com.drivinggrpc.driving.po.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BillDao {

    @Select("select * from bill where user_id=#{user_id}")
    List<Bill> selectBillByUserId(String user_id);

    @Insert("insert into bill(user_id,date,money,cause) value(#{user_id},#{date},#{money},#{cause})")
    int insertBill(Bill bill);

    @Update("update bill set state = #{state} where id = #{id}")
    int updateStateById(int id,int state);
}
